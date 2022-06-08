package org.spikeboot.spring.spring_boot_test.service

import org.spikeboot.spring.spring_boot_test.entity.Book
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class BookService (
    @Autowired
    val bookRepository: JpaRepository<Book, Long>
        ){

    fun getAllBooks() = bookRepository.findAll()

    fun getBookById(id:Long) = bookRepository.findById(id)

    fun saveOrUpdateBook(book: Book) = bookRepository.saveAndFlush(book)

    fun deleteBookById(id: Long) = bookRepository.deleteById(id)
}