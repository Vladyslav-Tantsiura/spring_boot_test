package org.spikeboot.spring.spring_boot_test.service

import org.spikeboot.spring.spring_boot_test.entity.Book
import org.spikeboot.spring.spring_boot_test.repositories.JpaBookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class JpaBookService(
    @Autowired
    val jpaBookRepository: JpaBookRepository
) {

    fun findAllBooks() = jpaBookRepository.findAll()

    fun findBookById(id: Long) = jpaBookRepository.findById(id)

    fun saveNewBook(book: Book) = jpaBookRepository.save(book)

    fun deleteBookById(id: Long) = jpaBookRepository.deleteById(id)
}