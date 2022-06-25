package org.spikeboot.spring.spring_boot_test.project_reactot

import org.reactivestreams.Publisher
import org.spikeboot.spring.spring_boot_test.project_reactot.domain.User
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration
import java.util.Arrays

class ReactorPractice {

    fun emptyFlux() = Flux.empty<Any>()

    fun fluxFooBar() = Flux.just("foo", "bar")

    fun fluxFromIterable() = Flux.fromIterable(Arrays.asList("foo", "bar"))

    fun fluxError() = Flux.error<Throwable>(RuntimeException())

    fun fluxInterval() = Flux.interval(Duration.ofMillis(100)).take(10).log()


    //    Mono который пускает сигнал завершения
    fun emptyMono() = Mono.empty<Any>()

    //    Mono который не пускает никакого сигнала
    fun monoWithNoSignal() = Mono.never<Any>()

    fun fluxWithUsers() = Flux.just<User>(
        User("swhite", null, null),
        User("jpinkman", null, null)
    )

    fun monoUserMap(mono: Mono<User>): Mono<User> {
        return mono.map { user ->
            User(
                user.username?.let { it.uppercase() },
                user.firstname?.let { it.uppercase() },
                user.lastname?.let { it.uppercase() })
        }
    }

    fun fluxAsynchronousUserCapitalize(flux: Flux<User>): Flux<User> {
        return flux.flatMap { it -> userMonoCapitalize(it) }
    }

    fun userMonoCapitalize(user: User): Mono<User> {
        return Mono.just(
            User(user.username?.let { it.uppercase() },
                user.firstname?.let { it.uppercase() },
                user.lastname?.let { it.uppercase() })
        )
    }

    fun userCapitalize(user: User): User {
        return User(user.username?.let { it.uppercase() },
            user.firstname?.let { it.uppercase() },
            user.lastname?.let { it.uppercase() })
    }

    fun monoWithErrorResume(mono: Mono<User>): Mono<User> {
        return mono.onErrorResume { _ -> Mono.just(User.SKYLER) }
    }


    fun intervalFlux(): Flux<Long>{
        return Flux.interval(Duration.ofSeconds(1)).take(3600).log()
    }



    fun zipCombine(publisher1: Publisher<String>, publisher2: Publisher<String>): Flux<User>{
        return  Flux.zip(publisher1,publisher2).map{User(it.t1, it.t2,null)}
    }

    fun fluxToMonoConvert(flux: Flux<String>): Mono<Void>{
        return flux.then();
    }
}


//fun main() {
//
////    Example using flatMap()
//
//    val flux1 = Flux.just(User(null, null, null), User(null, null, null))
//
//    val flux2 = Flux.just(User(null, null, null), User(null, null, null))
//
//    val ultimateFlux = Flux.just(flux1, flux2)
//
//    val result = ultimateFlux.flatMap { it }
//
//    result.subscribe(System.out::println)
//
//
//
//}