package org.spikeboot.spring.spring_boot_test.repositories

import org.spikeboot.spring.spring_boot_test.entity.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JpaBookRepository: JpaRepository<Book, Long> {
}