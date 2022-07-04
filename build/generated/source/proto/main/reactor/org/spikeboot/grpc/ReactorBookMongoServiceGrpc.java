package org.spikeboot.grpc;

import static org.spikeboot.grpc.BookMongoServiceGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;


@javax.annotation.Generated(
value = "by ReactorGrpc generator",
comments = "Source: Book.proto")
public final class ReactorBookMongoServiceGrpc {
    private ReactorBookMongoServiceGrpc() {}

    public static ReactorBookMongoServiceStub newReactorStub(io.grpc.Channel channel) {
        return new ReactorBookMongoServiceStub(channel);
    }

    public static final class ReactorBookMongoServiceStub extends io.grpc.stub.AbstractStub<ReactorBookMongoServiceStub> {
        private BookMongoServiceGrpc.BookMongoServiceStub delegateStub;

        private ReactorBookMongoServiceStub(io.grpc.Channel channel) {
            super(channel);
            delegateStub = BookMongoServiceGrpc.newStub(channel);
        }

        private ReactorBookMongoServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
            delegateStub = BookMongoServiceGrpc.newStub(channel).build(channel, callOptions);
        }

        @Override
        protected ReactorBookMongoServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ReactorBookMongoServiceStub(channel, callOptions);
        }

        public reactor.core.publisher.Mono<org.spikeboot.grpc.BookOuterClass.SucceedResponse> addNewBook(reactor.core.publisher.Mono<org.spikeboot.grpc.BookOuterClass.Book> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactorRequest, delegateStub::addNewBook, getCallOptions());
        }

        public reactor.core.publisher.Mono<org.spikeboot.grpc.BookOuterClass.SucceedResponse> existsBook(reactor.core.publisher.Mono<org.spikeboot.grpc.BookOuterClass.Book> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactorRequest, delegateStub::existsBook, getCallOptions());
        }

        public reactor.core.publisher.Flux<org.spikeboot.grpc.BookOuterClass.Book> findAllBook(reactor.core.publisher.Mono<com.google.protobuf.Empty> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToMany(reactorRequest, delegateStub::findAllBook, getCallOptions());
        }

        public reactor.core.publisher.Mono<org.spikeboot.grpc.BookOuterClass.SucceedResponse> saveAllBooks(reactor.core.publisher.Flux<org.spikeboot.grpc.BookOuterClass.Book> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.manyToOne(reactorRequest, delegateStub::saveAllBooks, getCallOptions());
        }

        public reactor.core.publisher.Flux<org.spikeboot.grpc.BookOuterClass.Book> getBooksByName(reactor.core.publisher.Flux<org.spikeboot.grpc.BookOuterClass.GetBooksByNameRequest> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.manyToMany(reactorRequest, delegateStub::getBooksByName, getCallOptions());
        }

        public reactor.core.publisher.Mono<org.spikeboot.grpc.BookOuterClass.GetBookByIdResponse> getBookById(reactor.core.publisher.Mono<org.spikeboot.grpc.BookOuterClass.GetBookByIdRequest> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactorRequest, delegateStub::getBookById, getCallOptions());
        }

        public reactor.core.publisher.Flux<org.spikeboot.grpc.BookOuterClass.Book> findAllBooksWithWithAdded(reactor.core.publisher.Mono<com.google.protobuf.Empty> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToMany(reactorRequest, delegateStub::findAllBooksWithWithAdded, getCallOptions());
        }

        public reactor.core.publisher.Mono<org.spikeboot.grpc.BookOuterClass.SucceedResponse> addNewBook(org.spikeboot.grpc.BookOuterClass.Book reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::addNewBook, getCallOptions());
        }

        public reactor.core.publisher.Mono<org.spikeboot.grpc.BookOuterClass.SucceedResponse> existsBook(org.spikeboot.grpc.BookOuterClass.Book reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::existsBook, getCallOptions());
        }

        public reactor.core.publisher.Flux<org.spikeboot.grpc.BookOuterClass.Book> findAllBook(com.google.protobuf.Empty reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToMany(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::findAllBook, getCallOptions());
        }

        public reactor.core.publisher.Mono<org.spikeboot.grpc.BookOuterClass.GetBookByIdResponse> getBookById(org.spikeboot.grpc.BookOuterClass.GetBookByIdRequest reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::getBookById, getCallOptions());
        }

        public reactor.core.publisher.Flux<org.spikeboot.grpc.BookOuterClass.Book> findAllBooksWithWithAdded(com.google.protobuf.Empty reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToMany(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::findAllBooksWithWithAdded, getCallOptions());
        }

    }

    public static abstract class BookMongoServiceImplBase implements io.grpc.BindableService {

        public reactor.core.publisher.Mono<org.spikeboot.grpc.BookOuterClass.SucceedResponse> addNewBook(reactor.core.publisher.Mono<org.spikeboot.grpc.BookOuterClass.Book> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        public reactor.core.publisher.Mono<org.spikeboot.grpc.BookOuterClass.SucceedResponse> existsBook(reactor.core.publisher.Mono<org.spikeboot.grpc.BookOuterClass.Book> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        public reactor.core.publisher.Flux<org.spikeboot.grpc.BookOuterClass.Book> findAllBook(reactor.core.publisher.Mono<com.google.protobuf.Empty> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        public reactor.core.publisher.Mono<org.spikeboot.grpc.BookOuterClass.SucceedResponse> saveAllBooks(reactor.core.publisher.Flux<org.spikeboot.grpc.BookOuterClass.Book> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        public reactor.core.publisher.Flux<org.spikeboot.grpc.BookOuterClass.Book> getBooksByName(reactor.core.publisher.Flux<org.spikeboot.grpc.BookOuterClass.GetBooksByNameRequest> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        public reactor.core.publisher.Mono<org.spikeboot.grpc.BookOuterClass.GetBookByIdResponse> getBookById(reactor.core.publisher.Mono<org.spikeboot.grpc.BookOuterClass.GetBookByIdRequest> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        public reactor.core.publisher.Flux<org.spikeboot.grpc.BookOuterClass.Book> findAllBooksWithWithAdded(reactor.core.publisher.Mono<com.google.protobuf.Empty> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            org.spikeboot.grpc.BookMongoServiceGrpc.getAddNewBookMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            org.spikeboot.grpc.BookOuterClass.Book,
                                            org.spikeboot.grpc.BookOuterClass.SucceedResponse>(
                                            this, METHODID_ADD_NEW_BOOK)))
                    .addMethod(
                            org.spikeboot.grpc.BookMongoServiceGrpc.getExistsBookMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            org.spikeboot.grpc.BookOuterClass.Book,
                                            org.spikeboot.grpc.BookOuterClass.SucceedResponse>(
                                            this, METHODID_EXISTS_BOOK)))
                    .addMethod(
                            org.spikeboot.grpc.BookMongoServiceGrpc.getFindAllBookMethod(),
                            asyncServerStreamingCall(
                                    new MethodHandlers<
                                            com.google.protobuf.Empty,
                                            org.spikeboot.grpc.BookOuterClass.Book>(
                                            this, METHODID_FIND_ALL_BOOK)))
                    .addMethod(
                            org.spikeboot.grpc.BookMongoServiceGrpc.getSaveAllBooksMethod(),
                            asyncClientStreamingCall(
                                    new MethodHandlers<
                                            org.spikeboot.grpc.BookOuterClass.Book,
                                            org.spikeboot.grpc.BookOuterClass.SucceedResponse>(
                                            this, METHODID_SAVE_ALL_BOOKS)))
                    .addMethod(
                            org.spikeboot.grpc.BookMongoServiceGrpc.getGetBooksByNameMethod(),
                            asyncBidiStreamingCall(
                                    new MethodHandlers<
                                            org.spikeboot.grpc.BookOuterClass.GetBooksByNameRequest,
                                            org.spikeboot.grpc.BookOuterClass.Book>(
                                            this, METHODID_GET_BOOKS_BY_NAME)))
                    .addMethod(
                            org.spikeboot.grpc.BookMongoServiceGrpc.getGetBookByIdMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            org.spikeboot.grpc.BookOuterClass.GetBookByIdRequest,
                                            org.spikeboot.grpc.BookOuterClass.GetBookByIdResponse>(
                                            this, METHODID_GET_BOOK_BY_ID)))
                    .addMethod(
                            org.spikeboot.grpc.BookMongoServiceGrpc.getFindAllBooksWithWithAddedMethod(),
                            asyncServerStreamingCall(
                                    new MethodHandlers<
                                            com.google.protobuf.Empty,
                                            org.spikeboot.grpc.BookOuterClass.Book>(
                                            this, METHODID_FIND_ALL_BOOKS_WITH_WITH_ADDED)))
                    .build();
        }

        protected io.grpc.CallOptions getCallOptions(int methodId) {
            return null;
        }

    }

    public static final int METHODID_ADD_NEW_BOOK = 0;
    public static final int METHODID_EXISTS_BOOK = 1;
    public static final int METHODID_FIND_ALL_BOOK = 2;
    public static final int METHODID_SAVE_ALL_BOOKS = 3;
    public static final int METHODID_GET_BOOKS_BY_NAME = 4;
    public static final int METHODID_GET_BOOK_BY_ID = 5;
    public static final int METHODID_FIND_ALL_BOOKS_WITH_WITH_ADDED = 6;

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final BookMongoServiceImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(BookMongoServiceImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_ADD_NEW_BOOK:
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToOne((org.spikeboot.grpc.BookOuterClass.Book) request,
                            (io.grpc.stub.StreamObserver<org.spikeboot.grpc.BookOuterClass.SucceedResponse>) responseObserver,
                            serviceImpl::addNewBook);
                    break;
                case METHODID_EXISTS_BOOK:
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToOne((org.spikeboot.grpc.BookOuterClass.Book) request,
                            (io.grpc.stub.StreamObserver<org.spikeboot.grpc.BookOuterClass.SucceedResponse>) responseObserver,
                            serviceImpl::existsBook);
                    break;
                case METHODID_FIND_ALL_BOOK:
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToMany((com.google.protobuf.Empty) request,
                            (io.grpc.stub.StreamObserver<org.spikeboot.grpc.BookOuterClass.Book>) responseObserver,
                            serviceImpl::findAllBook);
                    break;
                case METHODID_GET_BOOK_BY_ID:
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToOne((org.spikeboot.grpc.BookOuterClass.GetBookByIdRequest) request,
                            (io.grpc.stub.StreamObserver<org.spikeboot.grpc.BookOuterClass.GetBookByIdResponse>) responseObserver,
                            serviceImpl::getBookById);
                    break;
                case METHODID_FIND_ALL_BOOKS_WITH_WITH_ADDED:
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToMany((com.google.protobuf.Empty) request,
                            (io.grpc.stub.StreamObserver<org.spikeboot.grpc.BookOuterClass.Book>) responseObserver,
                            serviceImpl::findAllBooksWithWithAdded);
                    break;
                default:
                    throw new java.lang.AssertionError();
            }
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_SAVE_ALL_BOOKS:
                    return (io.grpc.stub.StreamObserver<Req>) com.salesforce.reactorgrpc.stub.ServerCalls.manyToOne(
                            (io.grpc.stub.StreamObserver<org.spikeboot.grpc.BookOuterClass.SucceedResponse>) responseObserver,
                            serviceImpl::saveAllBooks, serviceImpl.getCallOptions(methodId));
                case METHODID_GET_BOOKS_BY_NAME:
                    return (io.grpc.stub.StreamObserver<Req>) com.salesforce.reactorgrpc.stub.ServerCalls.manyToMany(
                            (io.grpc.stub.StreamObserver<org.spikeboot.grpc.BookOuterClass.Book>) responseObserver,
                            serviceImpl::getBooksByName, serviceImpl.getCallOptions(methodId));
                default:
                    throw new java.lang.AssertionError();
            }
        }
    }

}
