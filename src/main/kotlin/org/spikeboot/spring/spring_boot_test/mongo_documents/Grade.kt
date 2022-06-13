package org.spikeboot.spring.spring_boot_test.mongo_documents

import lombok.Data
import java.time.LocalDateTime

@Data
data class Grade (
    val date: LocalDateTime? = null,
    val grade: String? = null,
    val score: Int? = null
        ){
}