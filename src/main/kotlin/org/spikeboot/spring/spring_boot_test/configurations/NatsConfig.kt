package org.spikeboot.spring.spring_boot_test.configurations

import io.nats.client.Connection
import io.nats.client.Dispatcher
import io.nats.client.Nats
import io.nats.client.Options
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import reactor.kotlin.core.publisher.toMono
import java.nio.charset.StandardCharsets

@Configuration
class NatsConfig {

    @Bean
    fun initNatsConnection(): Connection {
        val natsUri: String = "nats://localhost:4222"
        return Nats.connect(natsUri)
    }

    @Bean
    fun asyncConnection(connection: Connection): Dispatcher {
        val dispatcher: Dispatcher = connection.createDispatcher { msg ->
            val str = String(msg.data, StandardCharsets.UTF_8)
            println("NATS receiving message: <<$str>>. From '${msg.subject}'")


//            Example of reply message (infinite replying)
//            connection.publish(msg.subject, "Replying message: $str".toByteArray(StandardCharsets.UTF_8))
        }
        dispatcher.subscribe("mongo.book.*")
        return dispatcher
    }
}