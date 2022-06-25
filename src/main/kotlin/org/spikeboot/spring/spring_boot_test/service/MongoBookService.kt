package org.spikeboot.spring.spring_boot_test.service

import org.spikeboot.spring.spring_boot_test.mongo_documents.Book
import org.spikeboot.spring.spring_boot_test.repositories.MongoBookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Service
import java.util.*

@Service
class MongoBookService(
    @Autowired
    val bookRepository: MongoBookRepository,
    val mongoTemplate: MongoTemplate
) {

    fun findAllBooks(): MutableList<Book> {
        return bookRepository.findAll()
    }

    fun findBookById(id: String): Optional<Book> {
        return bookRepository.findById(id)
    }

    fun saveBook(book: Book): Book {
        return bookRepository.save(book)
    }

    fun deleteBookById(id: String){
        return bookRepository.deleteById(id)
    }

}