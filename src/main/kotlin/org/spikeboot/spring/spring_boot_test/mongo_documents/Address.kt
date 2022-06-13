package org.spikeboot.spring.spring_boot_test.mongo_documents

import lombok.Data

@Data
data class Address (
    val building: String? = null,
    val coord: List<Double>? = null,
    val street: String? = null,
    val zipcode: String? = null
        ){
}