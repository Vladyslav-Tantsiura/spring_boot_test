package org.spikeboot.spring.spring_boot_test.service

import org.spikeboot.spring.spring_boot_test.mongo_documents.Restaurant
import org.spikeboot.spring.spring_boot_test.repositories.MongoRestaurantRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.find
import org.springframework.data.mongodb.core.query.*
import org.springframework.stereotype.Service

@Service
class RestaurantService(
    @Autowired
    val mongoRestaurantRepository: MongoRestaurantRepository,
    val template: MongoTemplate
) {

    fun findAllRestaurant() = mongoRestaurantRepository.findAll()


    fun findByRestaurantId(restaurantId: String): List<Restaurant?> {
        val query = Query()
        query.addCriteria(Criteria.where("restaurant_id").`is`(restaurantId))
        return template.find(query)
    }

    fun saveNewRestaurant(restaurant: Restaurant) = mongoRestaurantRepository.insert(restaurant)

    fun updateRestaurant(restaurant: Restaurant) {
        mongoRestaurantRepository.save(restaurant)
    }

    fun deleteRestaurantById(restaurantId: String) = mongoRestaurantRepository.deleteById(restaurantId)
}