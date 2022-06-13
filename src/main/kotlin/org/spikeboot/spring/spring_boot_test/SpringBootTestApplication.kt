package org.spikeboot.spring.spring_boot_test

import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.mongodb.core.MongoTemplate


@SpringBootApplication
class SpringBootTestApplication{

	@Bean
	fun mongoClient(): MongoClient{
		val connectionString = ConnectionString("mongodb+srv://megapp9:vBdSURPrVLL6DmTj@cluster0.el7mo.mongodb.net/myTestDB?retryWrites=true&w=majority")
		val mongoClientSettings = MongoClientSettings.builder()
			.applyConnectionString(connectionString)
			.build()

		return MongoClients.create(mongoClientSettings)
	}

	@Bean
	fun mongoTemplate(): MongoTemplate {
		return MongoTemplate(mongoClient(),"myTestDB")
	}
}

fun main(args: Array<String>) {
	runApplication<SpringBootTestApplication>(*args)


}
