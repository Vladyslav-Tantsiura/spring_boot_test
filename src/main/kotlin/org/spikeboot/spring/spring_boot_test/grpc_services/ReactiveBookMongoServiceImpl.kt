package org.spikeboot.spring.spring_boot_test.grpc_services

import com.google.protobuf.Empty
import org.lognet.springboot.grpc.GRpcService
import org.spikeboot.grpc.BookOuterClass
import org.spikeboot.grpc.ReactorBookMongoServiceGrpc
import org.spikeboot.spring.spring_boot_test.mongo_documents.Book
import org.spikeboot.spring.spring_boot_test.service.ReactiveMongoBookService
import org.springframework.beans.factory.annotation.Autowired
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration
import java.util.stream.Collectors
import org.spikeboot.grpc.BookOuterClass.Book as ProtoBook

@GRpcService
class ReactiveBookMongoServiceImpl(
    @Autowired
    val reactiveBookService: ReactiveMongoBookService
) : ReactorBookMongoServiceGrpc.BookMongoServiceImplBase() {

    //    Хороший пример реактивного gRPC
    @Override
    override fun addNewBook(request: Mono<ProtoBook>): Mono<BookOuterClass.SucceedResponse> {
        return request.flatMap {
            reactiveBookService
                .insertBook(
                    Book(
                        bookName = it.bookName,
                        author = it.author
                    )
                )
        }.mapToResponse()
    }

    fun Mono<Book>.mapToResponse(): Mono<BookOuterClass.SucceedResponse> {
        return map {
            BookOuterClass.SucceedResponse.newBuilder().setSucceeded(it is Book).build()
        }
    }


    //      Плохой пример реактивного gRPC - используется блокировка
    @Override
    override fun existsBook(request: Mono<ProtoBook>?): Mono<BookOuterClass.SucceedResponse>? {
        return request?.let { mono ->
            mono.map { book ->
                val response = BookOuterClass.SucceedResponse.newBuilder()

                reactiveBookService
                    .bookIsPresentById(book.id)
                    .map {
                        response.setSucceeded(it)
                        if (!it) {
                            response.setError("Not exist")
                        }
                    }.block()

                response.build()
            }
        }
    }


    @Override
    override fun findAllBook(request: Mono<Empty>): Flux<ProtoBook> {
        return reactiveBookService
            .findAllBooks()
            .delayElements(Duration.ofMillis(1000L))
            .map {
                it.bookToProtoBook()
            }
    }


    //    SucceedResponse вернется раньше чем закончиться client stream
//    только если не использовать blockLast()
    @Override
    override fun saveAllBooks(request: Flux<ProtoBook>): Mono<BookOuterClass.SucceedResponse> {
//        попробывать filter и switchIfEmpty (для маркера последнего елемента в стриме)
        return request.flatMap {
            reactiveBookService.insertBook(
                Book(
                    bookName = it.bookName,
                    author = it.author
                )
            )
        }
            .collect(Collectors.toList())
            .map { BookOuterClass.SucceedResponse.newBuilder().setSucceeded(true).build() }.log()
    }


    @Override
    override fun getBooksByName(request: Flux<BookOuterClass.GetBooksByNameRequest>): Flux<ProtoBook> {
        return request
            .flatMap { reactiveBookService.findBookByName(it.bookName) }
            .map { it.bookToProtoBook() }
    }

    fun Book.bookToProtoBook(): ProtoBook {
        return ProtoBook
            .newBuilder()
            .setId(this.id)
            .setBookName(this.bookName)
            .setAuthor(this.author)
            .build()
    }
}