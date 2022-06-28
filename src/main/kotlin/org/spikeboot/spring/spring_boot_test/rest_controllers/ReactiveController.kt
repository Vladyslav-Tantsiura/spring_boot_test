package org.spikeboot.spring.spring_boot_test.rest_controllers

import org.spikeboot.spring.spring_boot_test.mongo_documents.Book
import org.spikeboot.spring.spring_boot_test.service.ReactiveMongoBookService
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

@RestController
@RequestMapping("/react/api")
class ReactiveController(
    @Autowired
    val reactiveMongoBookService: ReactiveMongoBookService
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


    //    @GetMapping("/book")
//    fun getAllBooks() = reactiveBookService.findAllBooksWithTemplate()



    @GetMapping("/book")
    fun getAllBooks(): Flux<Book> {

        return reactiveMongoBookService.findAllBooksWithTemplate()
    }


//    Get all elements with delay for each element
//
//    @GetMapping("/book")
//    fun getAllBooks() = reactiveBookService
//        .findAllBooksWithTemplate()
//        .delayElements(Duration.ofSeconds(5))
//        .collectList()

//    @GetMapping("/book")
//    fun getAllBooks(): ArrayList<Book> {
//        val arrayList = ArrayList<Book>()
//
//        val abc = reactiveBookService.findAllBooksWithTemplate().map{it ->
//            arrayList.add(it)
//            it
//        }
//
//        abc.log().blockLast()
//        return arrayList
//    }

    @GetMapping("/book/{id}")
    fun getBookById(@PathVariable id: String) = reactiveMongoBookService.findBookById(id)

    @PostMapping("/book")
    fun addNewBook(@RequestBody book: Book): Mono<Book> {
        return reactiveMongoBookService.insertBook(book)
    }


}

//private fun <T> Flux<T>.blockToList(): List<T> =
//    collectList()
//        .blockOptional()
//        .orElse(listOf())