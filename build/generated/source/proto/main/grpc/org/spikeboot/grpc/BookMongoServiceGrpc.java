package org.spikeboot.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.44.0)",
    comments = "Source: Book.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class BookMongoServiceGrpc {

  private BookMongoServiceGrpc() {}

  public static final String SERVICE_NAME = "org.spikeboot.grpc.BookMongoService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.spikeboot.grpc.BookOuterClass.Book,
      org.spikeboot.grpc.BookOuterClass.SucceedResponse> getAddNewBookMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addNewBook",
      requestType = org.spikeboot.grpc.BookOuterClass.Book.class,
      responseType = org.spikeboot.grpc.BookOuterClass.SucceedResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.spikeboot.grpc.BookOuterClass.Book,
      org.spikeboot.grpc.BookOuterClass.SucceedResponse> getAddNewBookMethod() {
    io.grpc.MethodDescriptor<org.spikeboot.grpc.BookOuterClass.Book, org.spikeboot.grpc.BookOuterClass.SucceedResponse> getAddNewBookMethod;
    if ((getAddNewBookMethod = BookMongoServiceGrpc.getAddNewBookMethod) == null) {
      synchronized (BookMongoServiceGrpc.class) {
        if ((getAddNewBookMethod = BookMongoServiceGrpc.getAddNewBookMethod) == null) {
          BookMongoServiceGrpc.getAddNewBookMethod = getAddNewBookMethod =
              io.grpc.MethodDescriptor.<org.spikeboot.grpc.BookOuterClass.Book, org.spikeboot.grpc.BookOuterClass.SucceedResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addNewBook"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.spikeboot.grpc.BookOuterClass.Book.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.spikeboot.grpc.BookOuterClass.SucceedResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BookMongoServiceMethodDescriptorSupplier("addNewBook"))
              .build();
        }
      }
    }
    return getAddNewBookMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.spikeboot.grpc.BookOuterClass.Book,
      org.spikeboot.grpc.BookOuterClass.SucceedResponse> getExistsBookMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "existsBook",
      requestType = org.spikeboot.grpc.BookOuterClass.Book.class,
      responseType = org.spikeboot.grpc.BookOuterClass.SucceedResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.spikeboot.grpc.BookOuterClass.Book,
      org.spikeboot.grpc.BookOuterClass.SucceedResponse> getExistsBookMethod() {
    io.grpc.MethodDescriptor<org.spikeboot.grpc.BookOuterClass.Book, org.spikeboot.grpc.BookOuterClass.SucceedResponse> getExistsBookMethod;
    if ((getExistsBookMethod = BookMongoServiceGrpc.getExistsBookMethod) == null) {
      synchronized (BookMongoServiceGrpc.class) {
        if ((getExistsBookMethod = BookMongoServiceGrpc.getExistsBookMethod) == null) {
          BookMongoServiceGrpc.getExistsBookMethod = getExistsBookMethod =
              io.grpc.MethodDescriptor.<org.spikeboot.grpc.BookOuterClass.Book, org.spikeboot.grpc.BookOuterClass.SucceedResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "existsBook"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.spikeboot.grpc.BookOuterClass.Book.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.spikeboot.grpc.BookOuterClass.SucceedResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BookMongoServiceMethodDescriptorSupplier("existsBook"))
              .build();
        }
      }
    }
    return getExistsBookMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      org.spikeboot.grpc.BookOuterClass.Book> getFindAllBookMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "findAllBook",
      requestType = com.google.protobuf.Empty.class,
      responseType = org.spikeboot.grpc.BookOuterClass.Book.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      org.spikeboot.grpc.BookOuterClass.Book> getFindAllBookMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, org.spikeboot.grpc.BookOuterClass.Book> getFindAllBookMethod;
    if ((getFindAllBookMethod = BookMongoServiceGrpc.getFindAllBookMethod) == null) {
      synchronized (BookMongoServiceGrpc.class) {
        if ((getFindAllBookMethod = BookMongoServiceGrpc.getFindAllBookMethod) == null) {
          BookMongoServiceGrpc.getFindAllBookMethod = getFindAllBookMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, org.spikeboot.grpc.BookOuterClass.Book>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "findAllBook"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.spikeboot.grpc.BookOuterClass.Book.getDefaultInstance()))
              .setSchemaDescriptor(new BookMongoServiceMethodDescriptorSupplier("findAllBook"))
              .build();
        }
      }
    }
    return getFindAllBookMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.spikeboot.grpc.BookOuterClass.Book,
      org.spikeboot.grpc.BookOuterClass.SucceedResponse> getSaveAllBooksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "saveAllBooks",
      requestType = org.spikeboot.grpc.BookOuterClass.Book.class,
      responseType = org.spikeboot.grpc.BookOuterClass.SucceedResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<org.spikeboot.grpc.BookOuterClass.Book,
      org.spikeboot.grpc.BookOuterClass.SucceedResponse> getSaveAllBooksMethod() {
    io.grpc.MethodDescriptor<org.spikeboot.grpc.BookOuterClass.Book, org.spikeboot.grpc.BookOuterClass.SucceedResponse> getSaveAllBooksMethod;
    if ((getSaveAllBooksMethod = BookMongoServiceGrpc.getSaveAllBooksMethod) == null) {
      synchronized (BookMongoServiceGrpc.class) {
        if ((getSaveAllBooksMethod = BookMongoServiceGrpc.getSaveAllBooksMethod) == null) {
          BookMongoServiceGrpc.getSaveAllBooksMethod = getSaveAllBooksMethod =
              io.grpc.MethodDescriptor.<org.spikeboot.grpc.BookOuterClass.Book, org.spikeboot.grpc.BookOuterClass.SucceedResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "saveAllBooks"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.spikeboot.grpc.BookOuterClass.Book.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.spikeboot.grpc.BookOuterClass.SucceedResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BookMongoServiceMethodDescriptorSupplier("saveAllBooks"))
              .build();
        }
      }
    }
    return getSaveAllBooksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.spikeboot.grpc.BookOuterClass.GetBooksByNameRequest,
      org.spikeboot.grpc.BookOuterClass.Book> getGetBooksByNameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getBooksByName",
      requestType = org.spikeboot.grpc.BookOuterClass.GetBooksByNameRequest.class,
      responseType = org.spikeboot.grpc.BookOuterClass.Book.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<org.spikeboot.grpc.BookOuterClass.GetBooksByNameRequest,
      org.spikeboot.grpc.BookOuterClass.Book> getGetBooksByNameMethod() {
    io.grpc.MethodDescriptor<org.spikeboot.grpc.BookOuterClass.GetBooksByNameRequest, org.spikeboot.grpc.BookOuterClass.Book> getGetBooksByNameMethod;
    if ((getGetBooksByNameMethod = BookMongoServiceGrpc.getGetBooksByNameMethod) == null) {
      synchronized (BookMongoServiceGrpc.class) {
        if ((getGetBooksByNameMethod = BookMongoServiceGrpc.getGetBooksByNameMethod) == null) {
          BookMongoServiceGrpc.getGetBooksByNameMethod = getGetBooksByNameMethod =
              io.grpc.MethodDescriptor.<org.spikeboot.grpc.BookOuterClass.GetBooksByNameRequest, org.spikeboot.grpc.BookOuterClass.Book>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getBooksByName"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.spikeboot.grpc.BookOuterClass.GetBooksByNameRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.spikeboot.grpc.BookOuterClass.Book.getDefaultInstance()))
              .setSchemaDescriptor(new BookMongoServiceMethodDescriptorSupplier("getBooksByName"))
              .build();
        }
      }
    }
    return getGetBooksByNameMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BookMongoServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BookMongoServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BookMongoServiceStub>() {
        @java.lang.Override
        public BookMongoServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BookMongoServiceStub(channel, callOptions);
        }
      };
    return BookMongoServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BookMongoServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BookMongoServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BookMongoServiceBlockingStub>() {
        @java.lang.Override
        public BookMongoServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BookMongoServiceBlockingStub(channel, callOptions);
        }
      };
    return BookMongoServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BookMongoServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BookMongoServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BookMongoServiceFutureStub>() {
        @java.lang.Override
        public BookMongoServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BookMongoServiceFutureStub(channel, callOptions);
        }
      };
    return BookMongoServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class BookMongoServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void addNewBook(org.spikeboot.grpc.BookOuterClass.Book request,
        io.grpc.stub.StreamObserver<org.spikeboot.grpc.BookOuterClass.SucceedResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddNewBookMethod(), responseObserver);
    }

    /**
     */
    public void existsBook(org.spikeboot.grpc.BookOuterClass.Book request,
        io.grpc.stub.StreamObserver<org.spikeboot.grpc.BookOuterClass.SucceedResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExistsBookMethod(), responseObserver);
    }

    /**
     */
    public void findAllBook(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<org.spikeboot.grpc.BookOuterClass.Book> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindAllBookMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<org.spikeboot.grpc.BookOuterClass.Book> saveAllBooks(
        io.grpc.stub.StreamObserver<org.spikeboot.grpc.BookOuterClass.SucceedResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getSaveAllBooksMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<org.spikeboot.grpc.BookOuterClass.GetBooksByNameRequest> getBooksByName(
        io.grpc.stub.StreamObserver<org.spikeboot.grpc.BookOuterClass.Book> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getGetBooksByNameMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddNewBookMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.spikeboot.grpc.BookOuterClass.Book,
                org.spikeboot.grpc.BookOuterClass.SucceedResponse>(
                  this, METHODID_ADD_NEW_BOOK)))
          .addMethod(
            getExistsBookMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.spikeboot.grpc.BookOuterClass.Book,
                org.spikeboot.grpc.BookOuterClass.SucceedResponse>(
                  this, METHODID_EXISTS_BOOK)))
          .addMethod(
            getFindAllBookMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                org.spikeboot.grpc.BookOuterClass.Book>(
                  this, METHODID_FIND_ALL_BOOK)))
          .addMethod(
            getSaveAllBooksMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
              new MethodHandlers<
                org.spikeboot.grpc.BookOuterClass.Book,
                org.spikeboot.grpc.BookOuterClass.SucceedResponse>(
                  this, METHODID_SAVE_ALL_BOOKS)))
          .addMethod(
            getGetBooksByNameMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                org.spikeboot.grpc.BookOuterClass.GetBooksByNameRequest,
                org.spikeboot.grpc.BookOuterClass.Book>(
                  this, METHODID_GET_BOOKS_BY_NAME)))
          .build();
    }
  }

  /**
   */
  public static final class BookMongoServiceStub extends io.grpc.stub.AbstractAsyncStub<BookMongoServiceStub> {
    private BookMongoServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BookMongoServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BookMongoServiceStub(channel, callOptions);
    }

    /**
     */
    public void addNewBook(org.spikeboot.grpc.BookOuterClass.Book request,
        io.grpc.stub.StreamObserver<org.spikeboot.grpc.BookOuterClass.SucceedResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddNewBookMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void existsBook(org.spikeboot.grpc.BookOuterClass.Book request,
        io.grpc.stub.StreamObserver<org.spikeboot.grpc.BookOuterClass.SucceedResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExistsBookMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findAllBook(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<org.spikeboot.grpc.BookOuterClass.Book> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getFindAllBookMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<org.spikeboot.grpc.BookOuterClass.Book> saveAllBooks(
        io.grpc.stub.StreamObserver<org.spikeboot.grpc.BookOuterClass.SucceedResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getSaveAllBooksMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<org.spikeboot.grpc.BookOuterClass.GetBooksByNameRequest> getBooksByName(
        io.grpc.stub.StreamObserver<org.spikeboot.grpc.BookOuterClass.Book> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getGetBooksByNameMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class BookMongoServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<BookMongoServiceBlockingStub> {
    private BookMongoServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BookMongoServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BookMongoServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public org.spikeboot.grpc.BookOuterClass.SucceedResponse addNewBook(org.spikeboot.grpc.BookOuterClass.Book request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddNewBookMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.spikeboot.grpc.BookOuterClass.SucceedResponse existsBook(org.spikeboot.grpc.BookOuterClass.Book request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExistsBookMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<org.spikeboot.grpc.BookOuterClass.Book> findAllBook(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getFindAllBookMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BookMongoServiceFutureStub extends io.grpc.stub.AbstractFutureStub<BookMongoServiceFutureStub> {
    private BookMongoServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BookMongoServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BookMongoServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.spikeboot.grpc.BookOuterClass.SucceedResponse> addNewBook(
        org.spikeboot.grpc.BookOuterClass.Book request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddNewBookMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.spikeboot.grpc.BookOuterClass.SucceedResponse> existsBook(
        org.spikeboot.grpc.BookOuterClass.Book request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExistsBookMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_NEW_BOOK = 0;
  private static final int METHODID_EXISTS_BOOK = 1;
  private static final int METHODID_FIND_ALL_BOOK = 2;
  private static final int METHODID_SAVE_ALL_BOOKS = 3;
  private static final int METHODID_GET_BOOKS_BY_NAME = 4;

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
          serviceImpl.addNewBook((org.spikeboot.grpc.BookOuterClass.Book) request,
              (io.grpc.stub.StreamObserver<org.spikeboot.grpc.BookOuterClass.SucceedResponse>) responseObserver);
          break;
        case METHODID_EXISTS_BOOK:
          serviceImpl.existsBook((org.spikeboot.grpc.BookOuterClass.Book) request,
              (io.grpc.stub.StreamObserver<org.spikeboot.grpc.BookOuterClass.SucceedResponse>) responseObserver);
          break;
        case METHODID_FIND_ALL_BOOK:
          serviceImpl.findAllBook((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<org.spikeboot.grpc.BookOuterClass.Book>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAVE_ALL_BOOKS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.saveAllBooks(
              (io.grpc.stub.StreamObserver<org.spikeboot.grpc.BookOuterClass.SucceedResponse>) responseObserver);
        case METHODID_GET_BOOKS_BY_NAME:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getBooksByName(
              (io.grpc.stub.StreamObserver<org.spikeboot.grpc.BookOuterClass.Book>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class BookMongoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BookMongoServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.spikeboot.grpc.BookOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BookMongoService");
    }
  }

  private static final class BookMongoServiceFileDescriptorSupplier
      extends BookMongoServiceBaseDescriptorSupplier {
    BookMongoServiceFileDescriptorSupplier() {}
  }

  private static final class BookMongoServiceMethodDescriptorSupplier
      extends BookMongoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BookMongoServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (BookMongoServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BookMongoServiceFileDescriptorSupplier())
              .addMethod(getAddNewBookMethod())
              .addMethod(getExistsBookMethod())
              .addMethod(getFindAllBookMethod())
              .addMethod(getSaveAllBooksMethod())
              .addMethod(getGetBooksByNameMethod())
              .build();
        }
      }
    }
    return result;
  }
}
