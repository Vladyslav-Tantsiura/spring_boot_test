package org.spikeboot.spring.spring_boot_test.rest_controllers

import org.spikeboot.spring.spring_boot_test.entity.Book
import org.spikeboot.spring.spring_boot_test.mongo_documents.Restaurant
import org.spikeboot.spring.spring_boot_test.service.BookService
import org.spikeboot.spring.spring_boot_test.service.RestaurantService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class MainRestController(
    @Autowired
    val bookService: BookService,
    val restaurantService: RestaurantService
) {

    @GetMapping("/book")
    fun getAllBooks() = bookService.findAllBooks()

    @GetMapping("/book/{id}")
    fun getBookById(@PathVariable id: Long) = bookService.findBookById(id)

    @PostMapping("/book")
    fun addNewBook(@RequestBody book: Book) = bookService.saveOrUpdateBook(book)

    @PutMapping("/book")
    fun UpdateBook(@RequestBody book: Book) = bookService.saveOrUpdateBook(book)

    @DeleteMapping("/book/{id}")
    fun deleteBook(@PathVariable("id") id: Long) = bookService.deleteBookById(id)


    @GetMapping("/restaurant")
    fun getAllRestaurants(): List<Restaurant?> {
//        restaurantService.getAllRestaurant()

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

    @GetMapping("/restaurant/{id}")
    fun getRestaurantById(@RequestParam id:String) = restaurantService.findByRestaurantId(id)
}
