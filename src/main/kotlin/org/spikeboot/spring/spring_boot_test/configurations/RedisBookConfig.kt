package org.spikeboot.spring.spring_boot_test.configurations

import org.spikeboot.spring.spring_boot_test.project_reactot.domain.redis.Book
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.ReactiveRedisTemplate
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializationContext
import org.springframework.data.redis.serializer.StringRedisSerializer

//  https://www.baeldung.com/spring-data-redis-reactive

@Configuration
class RedisBookConfig{

//    Creation ConnectionFactory for reactive Redis
    @Bean
    fun reactiveRedisConnectionFactory(): ReactiveRedisConnectionFactory{
        return LettuceConnectionFactory("127.0.0.1", 6379)
    }

    @Bean
    fun reactiveRedisBookTemplate(reactiveRedisConnectionFactory: ReactiveRedisConnectionFactory): ReactiveRedisTemplate<String, Book>{
//        Сериализация колюча в последовательность байтов
        val keySerializer: StringRedisSerializer = StringRedisSerializer()

//        Сериализация объекта Book в последовательность байтов при помощи JSON
        val valueSerializer: Jackson2JsonRedisSerializer<Book> = Jackson2JsonRedisSerializer(Book::class.java)

        val builder: RedisSerializationContext.RedisSerializationContextBuilder<String, Book> = RedisSerializationContext.newSerializationContext(keySerializer)

        val context: RedisSerializationContext<String, Book> = builder.value(valueSerializer).build()

        return ReactiveRedisTemplate(reactiveRedisConnectionFactory, context)
    }





//
//    @Bean
//    fun reactiveKeyCommands(reactiveConnectionFactory: ReactiveRedisConnectionFactory): ReactiveKeyCommands{
//        return reactiveConnectionFactory.reactiveConnection.keyCommands()
//    }
//
//    @Bean
//    fun reactiveStringCommands(reactiveConnectionFactory: ReactiveRedisConnectionFactory): ReactiveStringCommands{
//        return reactiveConnectionFactory.reactiveConnection.stringCommands()
//    }
}