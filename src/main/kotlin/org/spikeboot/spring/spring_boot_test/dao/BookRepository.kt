package org.spikeboot.spring.spring_boot_test.dao

import org.spikeboot.spring.spring_boot_test.entity.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface Repository: JpaRepository<Book, Long> {
}