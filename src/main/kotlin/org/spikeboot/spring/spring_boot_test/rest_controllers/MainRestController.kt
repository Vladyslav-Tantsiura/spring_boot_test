package org.spikeboot.spring.spring_boot_test.rest_controllers

import org.spikeboot.spring.spring_boot_test.entity.Book
import org.spikeboot.spring.spring_boot_test.mongo_documents.Restaurant
import org.spikeboot.spring.spring_boot_test.service.JpaBookService
import org.spikeboot.spring.spring_boot_test.service.RestaurantService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class MainRestController(
    @Autowired
    val jpaBookService: JpaBookService,
    val restaurantService: RestaurantService
) {

//    Books controllers

    @GetMapping("/book")
    fun getAllBooks() = jpaBookService.findAllBooks()

    @GetMapping("/book/{id}")
    fun getBookById(@PathVariable id: Long) = jpaBookService.findBookById(id)

    @PostMapping("/book")
    fun addNewBook(@RequestBody book: Book) = jpaBookService.saveNewBook(book)

    @PutMapping("/book")
    fun UpdateBook(@RequestBody book: Book) = jpaBookService.saveNewBook(book)

    @DeleteMapping("/book/{id}")
    fun deleteBook(@PathVariable("id") id: Long) = jpaBookService.deleteBookById(id)




//    Restaurants controllers

    @GetMapping("/restaurant")
    fun getAllRestaurants(): List<Restaurant?> {

//    val restaurant = Restaurant(
//        restaurant_id = "7777777",
//        name = "Venecia",
//        address = Address("74", listOf(-66.6666, 77.7777),"Nezaleznosti", "04744"),
//        borough = "Center",
//        cuisine = "National",
//        id = "463278",
//        grades = listOf(Grade(LocalDateTime.now(), "A", 100))
//    )
//        restaurantService.saveNewRestaurant(restaurant)

        return restaurantService.findAllRestaurant()
    }

    @GetMapping("/restaurant/{restaurantId}")
    fun getRestaurantById(@PathVariable restaurantId: String) = restaurantService.findByRestaurantId(restaurantId)

    @PostMapping("/restaurant")
    fun addNewRestaurant(@RequestBody restaurant: Restaurant) = restaurantService.saveNewRestaurant(restaurant)

    @PutMapping("/restaurant")
    fun updateRestaurant(@RequestBody restaurant: Restaurant) = restaurantService.updateRestaurant(restaurant)

    @DeleteMapping("/restaurant/{restaurantId}")
    fun deleteRestaurantById(@PathVariable restaurantId: String) = restaurantService.deleteRestaurantById(restaurantId)
}
