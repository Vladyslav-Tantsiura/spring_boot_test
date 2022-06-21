package org.spikeboot.spring.spring_boot_test.configurations

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@Configuration
//@EnableReactiveMongoRepositories
class ReactiveMongoDBConfig {

    // Init two instance of reactive MongoClient

    @Autowired
    lateinit var reactiveMongoClient: com.mongodb.reactivestreams.client.MongoClient


    // Bean for Reactive MongoTemplate

    @Bean
    fun reactiveMongoTemplate(): ReactiveMongoTemplate {
        return ReactiveMongoTemplate(reactiveMongoClient, "myTestDB")
    }
}

//@Configuration
////@EnableReactiveMongoRepositories
//class ReactiveMongoDBConfig: AbstractReactiveMongoConfiguration() {
//
//    // Init two instance of reactive MongoClient
//
//    @Autowired
//    lateinit var reactiveMongoClient: com.mongodb.reactivestreams.client.MongoClient
//
//
//    // Bean for Reactive MongoTemplate
//
//    @Bean
//    fun reactiveMongoTemplate(): ReactiveMongoTemplate {
//        return ReactiveMongoTemplate(reactiveMongoClient, "myTestDB")
//    }
//
//    override fun getDatabaseName(): String {
//        return "myTestDB"
//    }
//}