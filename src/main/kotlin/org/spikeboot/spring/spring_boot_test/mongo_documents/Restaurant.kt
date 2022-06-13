package org.spikeboot.spring.spring_boot_test.mongo_documents

import lombok.Data
import org.bson.codecs.pojo.annotations.BsonProperty
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Data
@Document(collection = "restr")
data class Restaurant (
    @Id
    val id: String? = null,

    @Indexed(unique = true)
    @BsonProperty(value = "restaurant_id")
    val restaurant_id: String? = null,

    @BsonProperty(value = "name")
    val name: String? = null,

    @BsonProperty(value = "address")
    val address: Address? = null,

    @BsonProperty(value = "borough")
    val borough: String? = null,

    @BsonProperty(value = "cuisine")
    val cuisine: String? = null,

    @BsonProperty(value = "grades")
    val grades: List<Grade>? = null
        ){
}