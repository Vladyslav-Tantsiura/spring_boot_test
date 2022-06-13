package org.spikeboot.spring.spring_boot_test.service

import org.spikeboot.spring.spring_boot_test.mongo_documents.Restaurant
import org.spikeboot.spring.spring_boot_test.repositories.RestaurantRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.find
import org.springframework.data.mongodb.core.query.*
import org.springframework.stereotype.Service

@Service
class RestaurantService(
    @Autowired
    val restaurantRepository: RestaurantRepository,

    @Autowired
    val template: MongoTemplate
) {

    fun findAllRestaurant() = restaurantRepository.findAll()


    fun findByRestaurantId(restaurantId: String): List<Restaurant?>{
        val query = Query()
        query.addCriteria(Criteria.where("restaurant_id").`is`(restaurantId))

        return template.find(query)
    }

    fun saveNewRestaurant(restaurant: Restaurant) = restaurantRepository.insert(restaurant)

}