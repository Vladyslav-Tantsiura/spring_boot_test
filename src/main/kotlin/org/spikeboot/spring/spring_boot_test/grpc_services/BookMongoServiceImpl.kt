package org.spikeboot.spring.spring_boot_test.grpc_services

//import kotlinx.coroutines.delay
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.flow
//import org.lognet.springboot.grpc.GRpcService
//import org.spikeboot.grpc.BookMongoServiceGrpcKt
//import org.spikeboot.grpc.BookOuterClass
//import org.spikeboot.spring.spring_boot_test.service.MongoBookService
//import org.springframework.beans.factory.annotation.Autowired
//import org.spikeboot.spring.spring_boot_test.mongo_documents.Book
//
//@GRpcService
//class BookMongoServiceImpl(
//    @Autowired
//    val bookService: MongoBookService
//) : BookMongoServiceGrpcKt.BookMongoServiceCoroutineImplBase() {
//
//    override suspend fun addNewBook(request: BookOuterClass.Book): BookOuterClass.SucceedResponse {
//        val book = Book(bookName = request.bookName, author = request.author)
//
//        bookService.saveBook(book)
//
//        return BookOuterClass.SucceedResponse.newBuilder().setSucceeded(true).build()
//    }
//
//    override suspend fun editExistBook(request: BookOuterClass.Book): BookOuterClass.SucceedResponse {
//        val optionalBook = bookService.findBookById(request.id)
//
//        if (optionalBook.isPresent()) {
//            val existingBook = optionalBook.get()
//
//            val editedBook = Book(
//                id = existingBook.id,
//                bookName = request.bookName,
//                author = request.author
//            )
//
//            bookService.saveBook(editedBook)
//
//            return BookOuterClass.SucceedResponse.newBuilder().setSucceeded(true).build()
//        }
//
//        return BookOuterClass.SucceedResponse.newBuilder().setSucceeded(false)
//            .setError("This book dont exist, pls add to library").build()
//    }
//
////    This simple method use <server to client> async stream with Kotlin Flow
//    override fun findAllBook(request: BookOuterClass.Empty): Flow<BookOuterClass.Book> {
//        val allBooks = bookService.findAllBooks()
//
//        return flow {
//            for (book in allBooks) {
//                delay(1000L)
//                emit(
//                    BookOuterClass.Book
//                        .newBuilder()
//                        .setId(book.id)
//                        .setBookName(book.bookName)
//                        .setAuthor(book.author)
//                        .build()
//                )
//            }
//        }
//    }
//
//    override suspend fun saveAllBooks(requests: Flow<BookOuterClass.Book>): BookOuterClass.SucceedResponse {
//        requests.collect{ bookService::saveBook }
//
//        return BookOuterClass.SucceedResponse.newBuilder().setSucceeded(true).build()
//    }
//}