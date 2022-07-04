package org.spikeboot.spring.spring_boot_test.service

import com.google.protobuf.field
import org.spikeboot.spring.spring_boot_test.project_reactot.domain.redis.Book
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.*
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration

@Service
class ReactiveRedisService(
    @Autowired
    val reactiveRedisTemplate: ReactiveRedisTemplate<String, String>,
    val reactiveOpsForList: ReactiveListOperations<String, String> = reactiveRedisTemplate.opsForList(),

    val reactiveRedisBookTemplate: ReactiveRedisTemplate<String, Book>,
    val reactiveOpsForValueBook: ReactiveValueOperations<String, Book> = reactiveRedisBookTemplate.opsForValue(),

    val reactiveOpsForHashBook: ReactiveHashOperations<String, String, Book> = reactiveRedisBookTemplate.opsForHash()
) {
    companion object {
        private val LIST_KEY_NOTES: String = "notes"
        private val HASH_KEY_BOOKS: String = "h_books"
    }

//
//  Methods for Notes
//


    fun getNotesListLength(): Mono<Long> {
        return reactiveOpsForList.size(LIST_KEY_NOTES)
    }

    fun createNote(note: String): Mono<Long> {
        return reactiveOpsForList.leftPush(LIST_KEY_NOTES, note)
    }

    fun createNotes(vararg notes: String): Mono<Long> {
        val arr = notes
        val arr2 = notes.toList().toTypedArray()

        return reactiveOpsForList.leftPushAll(LIST_KEY_NOTES, *notes.toList().toTypedArray())
//        Мы разбиваем наш лист на набор элементов типа String,
//        а потом делаем из них Array, потому что vararg просит Array<out String>
//        или переменные типа String, но не в массиве, а как отдельные и полноценные личности.
//
//        * -  Это некий оператор spread,
//        который как раз разбивает наш лист на отдельные элементы типа String.
//
//        toTypedArray - собирает все элементы,
//        которые создала звёздочка и собирает их в Array, который как раз можно отдать как vararg.

//        не подходящий vararg
//        return reactiveOpsForList.leftPushAll(LIST_KEY_NOTES, notes)
    }

    fun pickAllNotes(): Flux<String> {
        return reactiveOpsForList.range(LIST_KEY_NOTES, 0, -1)
    }

    fun deleteAllNotesFromList(): Mono<Boolean> {
        return reactiveOpsForList.delete("notes")
    }


//
// Methods for Book
//

//    Need insert without id = null in Book
    fun addBookInCache(book: Book): Mono<Boolean> {
        return reactiveOpsForValueBook.set(book.id?:"null", book, Duration.ofSeconds(30))
    }

    fun getBookFromCacheById(id: String): Mono<Book> {
        return reactiveOpsForValueBook.get(id)
    }

    fun deleteBookFromCache(id: String): Mono<Boolean> {
        return reactiveOpsForValueBook.delete(id)
    }

    fun addBookToHash(field: String, value: Book): Mono<Boolean> {
        return reactiveOpsForHashBook.put(HASH_KEY_BOOKS, field, value)
    }

    fun deleteBookFromHash(field: String): Mono<Book> {
        return reactiveOpsForHashBook.get(HASH_KEY_BOOKS, field)
    }

}