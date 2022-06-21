package org.spikeboot.spring.spring_boot_test.mongo_documents

import lombok.Data
import org.bson.codecs.pojo.annotations.BsonProperty
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import java.time.Year

@Data
@Document(collection = "book")
data class Book(
    @Id
    val id: String? = null,

    @BsonProperty("bookName")
    val bookName: String? = null,

    @BsonProperty("author")
    val author: String? = null,

    @BsonProperty("year")
    var year: LocalDateTime? = null
)