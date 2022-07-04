package org.spikeboot.spring.spring_boot_test.service

import org.junit.Before
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.spikeboot.spring.spring_boot_test.SpringBootTestApplication
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono
import reactor.test.StepVerifier
import org.spikeboot.spring.spring_boot_test.mongo_documents.Book as MongoBook
import org.spikeboot.spring.spring_boot_test.project_reactot.domain.redis.Book as RedisBook


@SpringBootTest
internal class ReactiveRedisServiceTest {

    lateinit var reactiveRedisService: ReactiveRedisService
    lateinit var reactiveMongoBookService: ReactiveMongoBookService

    @Before
    @Autowired
    fun init(reactiveRedisService: ReactiveRedisService, reactiveMongoBookService: ReactiveMongoBookService) {
        this.reactiveRedisService = reactiveRedisService
        this.reactiveMongoBookService = reactiveMongoBookService
    }

    @Test
    fun createNoteTest() {
        val mono: Mono<Long> = reactiveRedisService
            .deleteAllNotesFromList()
            .flatMap { reactiveRedisService.createNote("My first note") }
            .log()

        StepVerifier
            .create(mono)
            .expectNext(1L)
            .verifyComplete()

//        reactiveRedisService
//            .getNotesListLength()
//            .subscribe { length ->
//                StepVerifier.create(mono)
//                    .expectNext(length)
//                    .verifyComplete()
//            }
    }

    @Test
    fun pickAllNotesTest() {
        val flux: Flux<String> = reactiveRedisService.pickAllNotes().log()


    }

    @Test
    fun addBookToCacheTest() {
        val mono = reactiveMongoBookService
            .findBookByName("Metro 2033")
            .flatMap { mongoBook ->
                reactiveRedisService
                    .addBookInCache(mongoBook.toRedisBook())
            }
            .log()


        StepVerifier.create(mono)
            .expectNext(true)
            .verifyComplete()
    }

    @Test
    fun deleteBookFromCacheTest() {
        val mono = reactiveRedisService.deleteBookFromCache("62b09e8f8b8d3b634adc6702").log()

        StepVerifier.create(mono)
            .expectNext(true)
            .verifyComplete()
    }


    @Test
    fun addBookToHashTest() {
        val mono = reactiveMongoBookService
            .findBookById("62b0a2908950f74ee5884d5d")
            .flatMap { mongoBook ->
                reactiveRedisService
                    .addBookToHash("hash_book1", mongoBook.toRedisBook())
            }
            .log()

        StepVerifier
            .create(mono)
            .expectNext(true)
            .verifyComplete()
    }

//    Extension fun for convert MongoDocumentBook to RedisBook interpretation
    fun MongoBook.toRedisBook(): RedisBook {
        return RedisBook(
            id = this.id,
            bookName = this.bookName,
            author = this.author
        )
    }
}