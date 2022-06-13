package org.spikeboot.spring.spring_boot_test.service

import org.spikeboot.spring.spring_boot_test.entity.Book
import org.spikeboot.spring.spring_boot_test.repositories.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BookService(
    @Autowired
    val bookRepository: BookRepository
) {

    fun findAllBooks() = bookRepository.findAll()

    fun findBookById(id: Long) = bookRepository.findById(id)

    fun saveOrUpdateBook(book: Book) = bookRepository.saveAndFlush(book)

    fun deleteBookById(id: Long) = bookRepository.deleteById(id)
}