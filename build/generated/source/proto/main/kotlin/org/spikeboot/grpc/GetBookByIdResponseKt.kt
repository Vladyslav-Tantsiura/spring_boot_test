//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: Book.proto

package org.spikeboot.grpc;

@kotlin.jvm.JvmSynthetic
public inline fun getBookByIdResponse(block: org.spikeboot.grpc.GetBookByIdResponseKt.Dsl.() -> kotlin.Unit): org.spikeboot.grpc.BookOuterClass.GetBookByIdResponse =
  org.spikeboot.grpc.GetBookByIdResponseKt.Dsl._create(org.spikeboot.grpc.BookOuterClass.GetBookByIdResponse.newBuilder()).apply { block() }._build()
public object GetBookByIdResponseKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: org.spikeboot.grpc.BookOuterClass.GetBookByIdResponse.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: org.spikeboot.grpc.BookOuterClass.GetBookByIdResponse.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): org.spikeboot.grpc.BookOuterClass.GetBookByIdResponse = _builder.build()

    /**
     * <code>string id = 1;</code>
     */
    public var id: kotlin.String
      @JvmName("getId")
      get() = _builder.getId()
      @JvmName("setId")
      set(value) {
        _builder.setId(value)
      }
    /**
     * <code>string id = 1;</code>
     */
    public fun clearId() {
      _builder.clearId()
    }

    /**
     * <code>string book_name = 2;</code>
     */
    public var bookName: kotlin.String
      @JvmName("getBookName")
      get() = _builder.getBookName()
      @JvmName("setBookName")
      set(value) {
        _builder.setBookName(value)
      }
    /**
     * <code>string book_name = 2;</code>
     */
    public fun clearBookName() {
      _builder.clearBookName()
    }

    /**
     * <code>string author = 3;</code>
     */
    public var author: kotlin.String
      @JvmName("getAuthor")
      get() = _builder.getAuthor()
      @JvmName("setAuthor")
      set(value) {
        _builder.setAuthor(value)
      }
    /**
     * <code>string author = 3;</code>
     */
    public fun clearAuthor() {
      _builder.clearAuthor()
    }
  }
}
@kotlin.jvm.JvmSynthetic
public inline fun org.spikeboot.grpc.BookOuterClass.GetBookByIdResponse.copy(block: org.spikeboot.grpc.GetBookByIdResponseKt.Dsl.() -> kotlin.Unit): org.spikeboot.grpc.BookOuterClass.GetBookByIdResponse =
  org.spikeboot.grpc.GetBookByIdResponseKt.Dsl._create(this.toBuilder()).apply { block() }._build()
