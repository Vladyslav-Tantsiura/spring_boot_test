package org.spikeboot.grpc

import com.google.protobuf.Empty
import io.grpc.CallOptions
import io.grpc.CallOptions.DEFAULT
import io.grpc.Channel
import io.grpc.Metadata
import io.grpc.MethodDescriptor
import io.grpc.ServerServiceDefinition
import io.grpc.ServerServiceDefinition.builder
import io.grpc.ServiceDescriptor
import io.grpc.Status
import io.grpc.Status.UNIMPLEMENTED
import io.grpc.StatusException
import io.grpc.kotlin.AbstractCoroutineServerImpl
import io.grpc.kotlin.AbstractCoroutineStub
import io.grpc.kotlin.ClientCalls
import io.grpc.kotlin.ClientCalls.bidiStreamingRpc
import io.grpc.kotlin.ClientCalls.clientStreamingRpc
import io.grpc.kotlin.ClientCalls.serverStreamingRpc
import io.grpc.kotlin.ClientCalls.unaryRpc
import io.grpc.kotlin.ServerCalls
import io.grpc.kotlin.ServerCalls.bidiStreamingServerMethodDefinition
import io.grpc.kotlin.ServerCalls.clientStreamingServerMethodDefinition
import io.grpc.kotlin.ServerCalls.serverStreamingServerMethodDefinition
import io.grpc.kotlin.ServerCalls.unaryServerMethodDefinition
import io.grpc.kotlin.StubFor
import kotlin.String
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic
import kotlinx.coroutines.flow.Flow
import org.spikeboot.grpc.BookMongoServiceGrpc.getServiceDescriptor

/**
 * Holder for Kotlin coroutine-based client and server APIs for org.spikeboot.grpc.BookMongoService.
 */
object BookMongoServiceGrpcKt {
  const val SERVICE_NAME: String = BookMongoServiceGrpc.SERVICE_NAME

  @JvmStatic
  val serviceDescriptor: ServiceDescriptor
    get() = BookMongoServiceGrpc.getServiceDescriptor()

  val addNewBookMethod: MethodDescriptor<BookOuterClass.Book, BookOuterClass.SucceedResponse>
    @JvmStatic
    get() = BookMongoServiceGrpc.getAddNewBookMethod()

  val existsBookMethod: MethodDescriptor<BookOuterClass.Book, BookOuterClass.SucceedResponse>
    @JvmStatic
    get() = BookMongoServiceGrpc.getExistsBookMethod()

  val findAllBookMethod: MethodDescriptor<Empty, BookOuterClass.Book>
    @JvmStatic
    get() = BookMongoServiceGrpc.getFindAllBookMethod()

  val saveAllBooksMethod: MethodDescriptor<BookOuterClass.Book, BookOuterClass.SucceedResponse>
    @JvmStatic
    get() = BookMongoServiceGrpc.getSaveAllBooksMethod()

  val getBooksByNameMethod: MethodDescriptor<BookOuterClass.GetBooksByNameRequest,
      BookOuterClass.Book>
    @JvmStatic
    get() = BookMongoServiceGrpc.getGetBooksByNameMethod()

  val getBookByIdMethod: MethodDescriptor<BookOuterClass.GetBookByIdRequest,
      BookOuterClass.GetBookByIdResponse>
    @JvmStatic
    get() = BookMongoServiceGrpc.getGetBookByIdMethod()

  val findAllBooksWithWithAddedMethod: MethodDescriptor<Empty, BookOuterClass.Book>
    @JvmStatic
    get() = BookMongoServiceGrpc.getFindAllBooksWithWithAddedMethod()

  /**
   * A stub for issuing RPCs to a(n) org.spikeboot.grpc.BookMongoService service as suspending
   * coroutines.
   */
  @StubFor(BookMongoServiceGrpc::class)
  class BookMongoServiceCoroutineStub @JvmOverloads constructor(
    channel: Channel,
    callOptions: CallOptions = DEFAULT
  ) : AbstractCoroutineStub<BookMongoServiceCoroutineStub>(channel, callOptions) {
    override fun build(channel: Channel, callOptions: CallOptions): BookMongoServiceCoroutineStub =
        BookMongoServiceCoroutineStub(channel, callOptions)

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    suspend fun addNewBook(request: BookOuterClass.Book, headers: Metadata = Metadata()):
        BookOuterClass.SucceedResponse = unaryRpc(
      channel,
      BookMongoServiceGrpc.getAddNewBookMethod(),
      request,
      callOptions,
      headers
    )
    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    suspend fun existsBook(request: BookOuterClass.Book, headers: Metadata = Metadata()):
        BookOuterClass.SucceedResponse = unaryRpc(
      channel,
      BookMongoServiceGrpc.getExistsBookMethod(),
      request,
      callOptions,
      headers
    )
    /**
     * Returns a [Flow] that, when collected, executes this RPC and emits responses from the
     * server as they arrive.  That flow finishes normally if the server closes its response with
     * [`Status.OK`][Status], and fails by throwing a [StatusException] otherwise.  If
     * collecting the flow downstream fails exceptionally (including via cancellation), the RPC
     * is cancelled with that exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return A flow that, when collected, emits the responses from the server.
     */
    fun findAllBook(request: Empty, headers: Metadata = Metadata()): Flow<BookOuterClass.Book> =
        serverStreamingRpc(
      channel,
      BookMongoServiceGrpc.getFindAllBookMethod(),
      request,
      callOptions,
      headers
    )
    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * This function collects the [Flow] of requests.  If the server terminates the RPC
     * for any reason before collection of requests is complete, the collection of requests
     * will be cancelled.  If the collection of requests completes exceptionally for any other
     * reason, the RPC will be cancelled for that reason and this method will throw that
     * exception.
     *
     * @param requests A [Flow] of request messages.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    suspend fun saveAllBooks(requests: Flow<BookOuterClass.Book>, headers: Metadata = Metadata()):
        BookOuterClass.SucceedResponse = clientStreamingRpc(
      channel,
      BookMongoServiceGrpc.getSaveAllBooksMethod(),
      requests,
      callOptions,
      headers
    )
    /**
     * Returns a [Flow] that, when collected, executes this RPC and emits responses from the
     * server as they arrive.  That flow finishes normally if the server closes its response with
     * [`Status.OK`][Status], and fails by throwing a [StatusException] otherwise.  If
     * collecting the flow downstream fails exceptionally (including via cancellation), the RPC
     * is cancelled with that exception as a cause.
     *
     * The [Flow] of requests is collected once each time the [Flow] of responses is
     * collected. If collection of the [Flow] of responses completes normally or
     * exceptionally before collection of `requests` completes, the collection of
     * `requests` is cancelled.  If the collection of `requests` completes
     * exceptionally for any other reason, then the collection of the [Flow] of responses
     * completes exceptionally for the same reason and the RPC is cancelled with that reason.
     *
     * @param requests A [Flow] of request messages.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return A flow that, when collected, emits the responses from the server.
     */
    fun getBooksByName(requests: Flow<BookOuterClass.GetBooksByNameRequest>, headers: Metadata =
        Metadata()): Flow<BookOuterClass.Book> = bidiStreamingRpc(
      channel,
      BookMongoServiceGrpc.getGetBooksByNameMethod(),
      requests,
      callOptions,
      headers
    )
    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    suspend fun getBookById(request: BookOuterClass.GetBookByIdRequest, headers: Metadata =
        Metadata()): BookOuterClass.GetBookByIdResponse = unaryRpc(
      channel,
      BookMongoServiceGrpc.getGetBookByIdMethod(),
      request,
      callOptions,
      headers
    )
    /**
     * Returns a [Flow] that, when collected, executes this RPC and emits responses from the
     * server as they arrive.  That flow finishes normally if the server closes its response with
     * [`Status.OK`][Status], and fails by throwing a [StatusException] otherwise.  If
     * collecting the flow downstream fails exceptionally (including via cancellation), the RPC
     * is cancelled with that exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return A flow that, when collected, emits the responses from the server.
     */
    fun findAllBooksWithWithAdded(request: Empty, headers: Metadata = Metadata()):
        Flow<BookOuterClass.Book> = serverStreamingRpc(
      channel,
      BookMongoServiceGrpc.getFindAllBooksWithWithAddedMethod(),
      request,
      callOptions,
      headers
    )}

  /**
   * Skeletal implementation of the org.spikeboot.grpc.BookMongoService service based on Kotlin
   * coroutines.
   */
  abstract class BookMongoServiceCoroutineImplBase(
    coroutineContext: CoroutineContext = EmptyCoroutineContext
  ) : AbstractCoroutineServerImpl(coroutineContext) {
    /**
     * Returns the response to an RPC for org.spikeboot.grpc.BookMongoService.addNewBook.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    open suspend fun addNewBook(request: BookOuterClass.Book): BookOuterClass.SucceedResponse =
        throw
        StatusException(UNIMPLEMENTED.withDescription("Method org.spikeboot.grpc.BookMongoService.addNewBook is unimplemented"))

    /**
     * Returns the response to an RPC for org.spikeboot.grpc.BookMongoService.existsBook.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    open suspend fun existsBook(request: BookOuterClass.Book): BookOuterClass.SucceedResponse =
        throw
        StatusException(UNIMPLEMENTED.withDescription("Method org.spikeboot.grpc.BookMongoService.existsBook is unimplemented"))

    /**
     * Returns a [Flow] of responses to an RPC for org.spikeboot.grpc.BookMongoService.findAllBook.
     *
     * If creating or collecting the returned flow fails with a [StatusException], the RPC
     * will fail with the corresponding [Status].  If it fails with a
     * [java.util.concurrent.CancellationException], the RPC will fail with status
     * `Status.CANCELLED`.  If creating
     * or collecting the returned flow fails for any other reason, the RPC will fail with
     * `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    open fun findAllBook(request: Empty): Flow<BookOuterClass.Book> = throw
        StatusException(UNIMPLEMENTED.withDescription("Method org.spikeboot.grpc.BookMongoService.findAllBook is unimplemented"))

    /**
     * Returns the response to an RPC for org.spikeboot.grpc.BookMongoService.saveAllBooks.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param requests A [Flow] of requests from the client.  This flow can be
     *        collected only once and throws [java.lang.IllegalStateException] on attempts to
     * collect
     *        it more than once.
     */
    open suspend fun saveAllBooks(requests: Flow<BookOuterClass.Book>):
        BookOuterClass.SucceedResponse = throw
        StatusException(UNIMPLEMENTED.withDescription("Method org.spikeboot.grpc.BookMongoService.saveAllBooks is unimplemented"))

    /**
     * Returns a [Flow] of responses to an RPC for
     * org.spikeboot.grpc.BookMongoService.getBooksByName.
     *
     * If creating or collecting the returned flow fails with a [StatusException], the RPC
     * will fail with the corresponding [Status].  If it fails with a
     * [java.util.concurrent.CancellationException], the RPC will fail with status
     * `Status.CANCELLED`.  If creating
     * or collecting the returned flow fails for any other reason, the RPC will fail with
     * `Status.UNKNOWN` with the exception as a cause.
     *
     * @param requests A [Flow] of requests from the client.  This flow can be
     *        collected only once and throws [java.lang.IllegalStateException] on attempts to
     * collect
     *        it more than once.
     */
    open fun getBooksByName(requests: Flow<BookOuterClass.GetBooksByNameRequest>):
        Flow<BookOuterClass.Book> = throw
        StatusException(UNIMPLEMENTED.withDescription("Method org.spikeboot.grpc.BookMongoService.getBooksByName is unimplemented"))

    /**
     * Returns the response to an RPC for org.spikeboot.grpc.BookMongoService.getBookById.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    open suspend fun getBookById(request: BookOuterClass.GetBookByIdRequest):
        BookOuterClass.GetBookByIdResponse = throw
        StatusException(UNIMPLEMENTED.withDescription("Method org.spikeboot.grpc.BookMongoService.getBookById is unimplemented"))

    /**
     * Returns a [Flow] of responses to an RPC for
     * org.spikeboot.grpc.BookMongoService.findAllBooksWithWithAdded.
     *
     * If creating or collecting the returned flow fails with a [StatusException], the RPC
     * will fail with the corresponding [Status].  If it fails with a
     * [java.util.concurrent.CancellationException], the RPC will fail with status
     * `Status.CANCELLED`.  If creating
     * or collecting the returned flow fails for any other reason, the RPC will fail with
     * `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    open fun findAllBooksWithWithAdded(request: Empty): Flow<BookOuterClass.Book> = throw
        StatusException(UNIMPLEMENTED.withDescription("Method org.spikeboot.grpc.BookMongoService.findAllBooksWithWithAdded is unimplemented"))

    final override fun bindService(): ServerServiceDefinition = builder(getServiceDescriptor())
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = BookMongoServiceGrpc.getAddNewBookMethod(),
      implementation = ::addNewBook
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = BookMongoServiceGrpc.getExistsBookMethod(),
      implementation = ::existsBook
    ))
      .addMethod(serverStreamingServerMethodDefinition(
      context = this.context,
      descriptor = BookMongoServiceGrpc.getFindAllBookMethod(),
      implementation = ::findAllBook
    ))
      .addMethod(clientStreamingServerMethodDefinition(
      context = this.context,
      descriptor = BookMongoServiceGrpc.getSaveAllBooksMethod(),
      implementation = ::saveAllBooks
    ))
      .addMethod(bidiStreamingServerMethodDefinition(
      context = this.context,
      descriptor = BookMongoServiceGrpc.getGetBooksByNameMethod(),
      implementation = ::getBooksByName
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = BookMongoServiceGrpc.getGetBookByIdMethod(),
      implementation = ::getBookById
    ))
      .addMethod(serverStreamingServerMethodDefinition(
      context = this.context,
      descriptor = BookMongoServiceGrpc.getFindAllBooksWithWithAddedMethod(),
      implementation = ::findAllBooksWithWithAdded
    )).build()
  }
}
