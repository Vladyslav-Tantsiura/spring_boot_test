package org.spikeboot.spring.spring_boot_test.rest_controllers

import org.spikeboot.spring.spring_boot_test.mongo_documents.Book
import org.spikeboot.spring.spring_boot_test.service.ReactiveBookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono
import java.time.LocalDateTime

@RestController
@RequestMapping("/react/api")
class ReactiveController(
    @Autowired
    val reactiveBookService: ReactiveBookService
) {

    @RequestMapping("/test")
    fun test() = Mono.just("Test!")


    //    http://localhost:8080/react/api/greet?name=MyName
    @RequestMapping("/greet")
    fun greetings(@RequestParam name: String) = Mono.just("Hello $name")

    //    Infinite response
    @RequestMapping("/wait")
    fun waiting() = Mono.never<String>()

    //    Page with error
    @RequestMapping("/error")
    fun errorPage() = Mono.error<Throwable>(IllegalStateException())


    @GetMapping("/book")
    fun getAllBooks() = reactiveBookService.findAllBooksWithTemplate()
//    : ArrayList<Book> {
//        val list = ArrayList<Book>()
//        reactiveBookService.findAllBooks().subscribe{list.add(it)}
//
//        return list
//    }

    @GetMapping("/book/{id}")
    fun getBookById(@PathVariable id: String) = reactiveBookService.findBookById(id)

    @PostMapping("/book")
    fun addNewBook(@RequestBody book: Book): Flux<Book> {
        book.year = LocalDateTime.now()
       return reactiveBookService.insertBook(book)
    }


}

//private fun <T> Flux<T>.blockToList(): List<T> =
//    collectList()
//        .blockOptional()
//        .orElse(listOf())