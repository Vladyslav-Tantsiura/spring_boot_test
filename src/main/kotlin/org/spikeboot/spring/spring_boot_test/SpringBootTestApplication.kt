package org.spikeboot.spring.spring_boot_test

import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.ServerApi
import com.mongodb.ServerApiVersion
import com.mongodb.reactivestreams.client.MongoClients
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories


@SpringBootApplication
class SpringBootTestApplication{

////	Init instance of blocking MongoClient
//	@Autowired
//	lateinit var mongoClient: com.mongodb.client.MongoClient
//
////	Bean for blocking MongoTemplate
//	@Bean
//	fun mongoTemplate(): MongoTemplate {
//		return MongoTemplate(mongoClient,"myTestDB")
//	}

//	Configure Settings for MongoClient, doesn't need if use application.properties for MongoDB

//	@Bean
//	fun reactiveMongoTemplate(): ReactiveMongoTemplate{
//
//		val connectionString =
//			ConnectionString("mongodb+srv://megapp9:vBdSURPrVLL6DmTj@cluster0.el7mo.mongodb.net/?retryWrites=true&w=majority")
//		val settings = MongoClientSettings.builder()
//			.applyConnectionString(connectionString)
//			.serverApi(
//				ServerApi.builder()
//					.version(ServerApiVersion.V1)
//					.build()
//			)
//			.build()
//
//		return ReactiveMongoTemplate(MongoClients.create(settings), "myTestDB")
//	}
}

fun main(args: Array<String>) {
	runApplication<SpringBootTestApplication>(*args)
}
