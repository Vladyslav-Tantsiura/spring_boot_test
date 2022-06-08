package org.spikeboot.spring.spring_boot_test.rest_controllers

import org.spikeboot.spring.spring_boot_test.entity.Book
import org.spikeboot.spring.spring_boot_test.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class MainRestController(
    @Autowired
    val bookService: BookService
) {

    @GetMapping("/book")
    fun getAllBooks() = bookService.getAllBooks()

    @GetMapping("/book/{id}")
    fun getBookById(@PathVariable id:Long) = bookService.getBookById(id)

    @PostMapping("/book")
    fun addNewBook(@RequestBody book:Book) = bookService.saveOrUpdateBook(book)

    @PutMapping("/book")
    fun UpdateBook(@RequestBody book:Book) = bookService.saveOrUpdateBook(book)

    @DeleteMapping("/book/{id}")
    fun deleteBook(@PathVariable id:Long) = bookService.deleteBookById(id)

}
