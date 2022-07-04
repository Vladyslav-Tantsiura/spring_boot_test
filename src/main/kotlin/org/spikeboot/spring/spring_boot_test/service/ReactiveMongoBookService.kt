package org.spikeboot.spring.spring_boot_test.service

import io.nats.client.Connection
import org.reactivestreams.Publisher
import org.spikeboot.spring.spring_boot_test.mongo_documents.Book
import org.spikeboot.spring.spring_boot_test.repositories.ReactiveMongoBookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono
import java.nio.charset.StandardCharsets

@Service
class ReactiveMongoBookService(
    @Autowired
    val reactiveMongoBookRepository: ReactiveMongoBookRepository,
    val reactiveMongoBookTemplate: ReactiveMongoTemplate,
    val natsConnection: Connection
) {

    fun insertBook(book: Book): Mono<Book> {
        return reactiveMongoBookRepository.insert(book).flatMap { book ->
            natsConnection.publish("mongo.book.add", "${book.id}|${book.bookName}|${book.author}".toByteArray(StandardCharsets.UTF_8))
            book.toMono()
        }
    }

    fun saveWithTemplate(book: Mono<Book>) = reactiveMongoBookTemplate.save(book)

//        val instanceBook = Book(bookName = "Alice in wonderland", author = "Lewis Carrol", year = Year.parse("1865"))
//        reactiveMongoTemplate.insert(instanceBook)
//        return reactiveBookRepository.insert(Mono.fromCallable { Book(bookName = "Alice in wonderland", author = "Lewis Carrol", year = Year.parse("1865")) })

    fun findAllBooksWithTemplate() = reactiveMongoBookTemplate.findAll(Book::class.java)

    fun findAllBooks() = reactiveMongoBookRepository.findAll()

    fun findBookByName(bookName: String): Mono<Book> {
        return reactiveMongoBookRepository.findBookByBookName(bookName)
    }

    fun findBookById(id: String) = reactiveMongoBookRepository.findById(id.toMono())

    fun bookIsPresentById(id: String): Mono<Boolean> {
        return reactiveMongoBookRepository.existsById(id)
    }

    fun saveAll(publisher: Publisher<Book>): Flux<Book> {
        return reactiveMongoBookRepository.saveAll(publisher)
    }

}