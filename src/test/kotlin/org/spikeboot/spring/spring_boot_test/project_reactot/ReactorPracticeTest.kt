package org.spikeboot.spring.spring_boot_test.project_reactot

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.spikeboot.spring.spring_boot_test.mongo_documents.Book
import org.spikeboot.spring.spring_boot_test.project_reactot.domain.User
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono
import reactor.test.StepVerifier
import java.time.Duration
import java.time.Year

internal class ReactorPracticeTest {
    companion object {
        val reactManager = ReactorPractice()
    }

    @Test
    fun emptyFluxTest() {
        StepVerifier.create(reactManager.emptyFlux()).verifyComplete()
    }

    @Test
    fun fluxFooBarTest() {
        StepVerifier.create(reactManager.fluxFooBar())
            .expectNext("foo", "bar")
            .verifyComplete()
    }

    @Test
    fun fluxFromIterableTest() {
        StepVerifier.create(reactManager.fluxFromIterable())
            .expectNext("foo", "bar")
            .verifyComplete()
    }

    @Test
    fun fluxErrorTest() {
        StepVerifier.create(reactManager.fluxError()).verifyError()
    }

    @Test
    fun fluxIntervalTest() {
        StepVerifier.create(reactManager.fluxInterval()).expectNext(0, 1, 2, 3, 4, 5, 6, 7, 8, 9).verifyComplete()
    }


    @Test
    fun emptyMonoTest() {
        StepVerifier.create(reactManager.emptyMono()).verifyComplete()
    }

    @Test
    fun monoWithNoSignalTest() {
        StepVerifier.create(reactManager.monoWithNoSignal())
            .expectSubscription() // Check subscription on Publisher
            .expectNoEvent(Duration.ofSeconds(1)) // Wait any event in 1 sec
            .thenCancel() // Cancel subscription after previous step
            .verify() // Init subscription
    }

    @Test
    fun fluxWithUsersTest() {
        StepVerifier.create(reactManager.fluxWithUsers())
            .expectNextMatches { it.username == "swhite" }
            .expectNextMatches { it.username == "jpinkman" }
            .verifyComplete()
    }

    @Test
    fun monoUserMapTest() {
        val monoUser = Mono.just(User("jeremy", null, null))

        StepVerifier.create(reactManager.monoUserMap(monoUser))
            .expectNextMatches { it.username == "JEREMY" }
            .expectComplete()
            .verify()
    }


    @Test
    fun monoErrorResumeTest() {
        val mono: Mono<User> = reactManager.monoWithErrorResume(Mono.error(IllegalStateException()))

        StepVerifier
            .create(mono)
            .expectNext(User.SKYLER)
            .verifyComplete()
    }


    //    https://stackoverflow.com/questions/60576916/why-stepverifer-virtual-time-not-works-on-flux
    @Test
    fun intervalTimeTest() {
        val flux = reactManager.intervalFlux()

        StepVerifier.withVirtualTime {reactManager.intervalFlux()}
            .thenAwait(Duration.ofSeconds(3600))
            .expectNextCount(3600)
            .verifyComplete()


//          Doesn't work
//        StepVerifier.withVirtualTime{flux}
//            .thenAwait(Duration.ofSeconds(3600))
//            .expectNextCount(3600)
//            .verifyComplete()
        //Flux.interval(Duration.ofSeconds(1)).take(3600).log()
    }

    @Test
    fun zipCombineTest(){
        val f1 = Flux.just("Margo", "Jack", "Rob")
        val f2 = Flux.just("Jix", "Back", "Fill")

        StepVerifier
            .create(reactManager.zipCombine(f1, f2))
            .expectNextMatches{it == User("Margo", "Jix", null)}
            .expectNextMatches{it == User("Jack", "Back", null)}
            .expectNextMatches{it == User("Rob", "Fill", null)}
            .expectComplete()
            .verify()
    }

//    @Test
//    fun toMonoTest(){
//        val instanceBook = Book(bookName = "Alice in wonderland", author = "Lewis Carrol", year = Year.parse("1865"))
//
//        StepVerifier
//            .create(instanceBook.toMono().log())
//            .expectNext(Book(bookName = "Alice in wonderland", author = "Lewis Carrol", year = Year.parse("1865")))
//
//    }













}