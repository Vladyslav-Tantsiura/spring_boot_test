package org.spikeboot.spring.spring_boot_test.configurations

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.MongoTemplate

@Configuration
class MongoDBConfig {

    //	Init instance of blocking MongoClient

    @Autowired
    lateinit var mongoClient: com.mongodb.client.MongoClient


    //	Bean for blocking MongoTemplate

    @Bean
    fun mongoTemplate(): MongoTemplate {
        return MongoTemplate(mongoClient,"myTestDB")
    }
}