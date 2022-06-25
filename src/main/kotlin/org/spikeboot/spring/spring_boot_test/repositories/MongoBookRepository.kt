package org.spikeboot.spring.spring_boot_test.repositories

import org.spikeboot.spring.spring_boot_test.mongo_documents.Book
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface MongoBookRepository: MongoRepository<Book, String> {
}