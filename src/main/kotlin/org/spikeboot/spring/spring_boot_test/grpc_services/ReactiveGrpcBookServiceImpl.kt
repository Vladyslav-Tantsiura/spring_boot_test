package org.spikeboot.spring.spring_boot_test.grpc_services

import com.google.protobuf.Empty
import io.nats.client.Connection
import org.lognet.springboot.grpc.GRpcService
import org.spikeboot.grpc.BookOuterClass
import org.spikeboot.grpc.ReactorBookMongoServiceGrpc
import org.spikeboot.spring.spring_boot_test.project_reactot.domain.redis.Book as RedisBook
import org.spikeboot.spring.spring_boot_test.service.ReactiveMongoBookService
import org.spikeboot.spring.spring_boot_test.service.ReactiveRedisService
import org.springframework.beans.factory.annotation.Autowired
import reactor.core.publisher.Flux
import reactor.core.publisher.FluxSink
import reactor.core.publisher.Mono
import reactor.core.publisher.MonoSink
import reactor.kotlin.core.publisher.toMono
import java.nio.charset.StandardCharsets
import java.time.Duration
import java.util.stream.Collectors
import org.spikeboot.grpc.BookOuterClass.Book as ProtoBook
import org.spikeboot.spring.spring_boot_test.mongo_documents.Book as MongoBook

@GRpcService
class ReactiveGrpcBookServiceImpl(
    @Autowired
    val reactiveMongoBookService: ReactiveMongoBookService,
    val reactiveRedisService: ReactiveRedisService,

    val natsConnection: Connection
) : ReactorBookMongoServiceGrpc.BookMongoServiceImplBase() {


    //    Хороший пример реактивного gRPC
    @Override
    override fun addNewBook(request: Mono<ProtoBook>): Mono<BookOuterClass.SucceedResponse> {
        return request.flatMap {
            reactiveMongoBookService
                .insertBook(
                    MongoBook(
                        bookName = it.bookName,
                        author = it.author
                    )
                )
        }.mapToResponse()
    }


    //      Плохой пример реактивного gRPC - используется блокировка
    @Override
    override fun existsBook(request: Mono<ProtoBook>?): Mono<BookOuterClass.SucceedResponse>? {
        return request?.let { mono ->
            mono.map { book ->
                val response = BookOuterClass.SucceedResponse.newBuilder()

                reactiveMongoBookService
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


    //    Getting Book with caching
    override fun getBookById(request: Mono<BookOuterClass.GetBookByIdRequest>): Mono<BookOuterClass.GetBookByIdResponse> {

//        get instance Book from MongoDB and write in cache on 30 sec then return instance of RedisBook
        val cachingAndGetInstance = request
            .flatMap { request ->
                reactiveMongoBookService.findBookById(request.id)
            }
            .map { mongoBook ->
                RedisBook(
                    id = mongoBook.id,
                    bookName = mongoBook.bookName,
                    author = mongoBook.author
                )
            }
            .flatMap { redisBook ->
//          adding book into cache
                reactiveRedisService
                    .addBookInCache(redisBook)
                    .then(redisBook.toMono())
            }

//        checking for redis cache instance book and if he empty write in cache and return GetBookByIdResponse
        return request
            .flatMap { reactiveRedisService.getBookFromCacheById(it.id) }
            .switchIfEmpty(cachingAndGetInstance)
            .map { redisBook ->
                BookOuterClass.GetBookByIdResponse
                    .newBuilder()
                    .setId(redisBook.id)
                    .setBookName(redisBook.bookName)
                    .setAuthor(redisBook.author)
                    .build()

            }
    }


    @Override
    override fun findAllBook(request: Mono<Empty>): Flux<ProtoBook> {
        return reactiveMongoBookService
            .findAllBooks()
            .map {
                it.mongoBookToProtoBook()
            }
    }


    override fun findAllBooksWithWithAdded(request: Mono<Empty>): Flux<ProtoBook> {

        val fluxSink = Flux.create { sink: FluxSink<MongoBook> ->
            var book: MongoBook

            natsConnection.createDispatcher().subscribe("mongo.book.add") { msg ->
                val splittedMsgData = String(msg.data, StandardCharsets.UTF_8).split("|")

                book = MongoBook(
                    id = splittedMsgData[0],
                    bookName = splittedMsgData[1],
                    author = splittedMsgData[2]
                )

                sink.next(book)
            }
        }

        return Flux.merge(reactiveMongoBookService.findAllBooks(), fluxSink)
            .map {
                it.mongoBookToProtoBook()
            }
    }


    @Override
    override fun saveAllBooks(request: Flux<ProtoBook>): Mono<BookOuterClass.SucceedResponse> {
//        попробывать filter и switchIfEmpty (для маркера последнего елемента в стриме)
        return request.flatMap {
            reactiveMongoBookService.insertBook(
                MongoBook(
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
            .flatMap { reactiveMongoBookService.findBookByName(it.bookName) }
            .map { it.mongoBookToProtoBook() }
    }

    //===================================================================================
//      Extensions
//===================================================================================
    fun Mono<MongoBook>.mapToResponse(): Mono<BookOuterClass.SucceedResponse> {
        return map {
            BookOuterClass.SucceedResponse.newBuilder().setSucceeded(it is MongoBook).build()
        }
    }

    fun MongoBook.mongoBookToProtoBook(): ProtoBook {
        return ProtoBook
            .newBuilder()
            .setId(this.id)
            .setBookName(this.bookName)
            .setAuthor(this.author)
            .build()
    }
}