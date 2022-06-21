package org.spikeboot.spring.spring_boot_test.repositories

import org.spikeboot.spring.spring_boot_test.mongo_documents.Book
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ReactiveBookRepository: ReactiveMongoRepository<Book, String>{
}