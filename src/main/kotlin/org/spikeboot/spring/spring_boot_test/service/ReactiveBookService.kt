package org.spikeboot.spring.spring_boot_test.service

import org.spikeboot.spring.spring_boot_test.mongo_documents.Book
import org.spikeboot.spring.spring_boot_test.repositories.ReactiveBookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono
import java.time.Year

@Service
class ReactiveBookService(
    @Autowired
    val reactiveBookRepository: ReactiveBookRepository,
    val reactiveMongoTemplate: ReactiveMongoTemplate
) {

    fun insertBook(book: Book) = reactiveBookRepository.insert(book.toMono())

    fun saveWithTemplate(book: Mono<Book>) = reactiveMongoTemplate.save(book)

//        val instanceBook = Book(bookName = "Alice in wonderland", author = "Lewis Carrol", year = Year.parse("1865"))
//        reactiveMongoTemplate.insert(instanceBook)
//        return reactiveBookRepository.insert(Mono.fromCallable { Book(bookName = "Alice in wonderland", author = "Lewis Carrol", year = Year.parse("1865")) })

    fun findAllBooksWithTemplate() = reactiveMongoTemplate.findAll(Book::class.java)

    fun findAllBooks() = reactiveBookRepository.findAll()

    fun findBookById(id: String) = reactiveBookRepository.findById(Mono.just(id))


}