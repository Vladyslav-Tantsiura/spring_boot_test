package org.spikeboot.spring.spring_boot_test.entity

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "book")
@Entity
data class Book (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id:Long? = null,


    @Column(name = "book_name", nullable = false)
    val bookName: String? = null,

    @Column(name = "author")
    val author: String? = null,

    @Column(name = "date")
    val date: Date? = null
)