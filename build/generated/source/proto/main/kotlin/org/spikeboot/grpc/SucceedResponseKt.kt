//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: Book.proto

package org.spikeboot.grpc;

@kotlin.jvm.JvmSynthetic
public inline fun succeedResponse(block: org.spikeboot.grpc.SucceedResponseKt.Dsl.() -> kotlin.Unit): org.spikeboot.grpc.BookOuterClass.SucceedResponse =
  org.spikeboot.grpc.SucceedResponseKt.Dsl._create(org.spikeboot.grpc.BookOuterClass.SucceedResponse.newBuilder()).apply { block() }._build()
public object SucceedResponseKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: org.spikeboot.grpc.BookOuterClass.SucceedResponse.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: org.spikeboot.grpc.BookOuterClass.SucceedResponse.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): org.spikeboot.grpc.BookOuterClass.SucceedResponse = _builder.build()

    /**
     * <code>bool succeeded = 1;</code>
     */
    public var succeeded: kotlin.Boolean
      @JvmName("getSucceeded")
      get() = _builder.getSucceeded()
      @JvmName("setSucceeded")
      set(value) {
        _builder.setSucceeded(value)
      }
    /**
     * <code>bool succeeded = 1;</code>
     */
    public fun clearSucceeded() {
      _builder.clearSucceeded()
    }

    /**
     * <code>string error = 2;</code>
     */
    public var error: kotlin.String
      @JvmName("getError")
      get() = _builder.getError()
      @JvmName("setError")
      set(value) {
        _builder.setError(value)
      }
    /**
     * <code>string error = 2;</code>
     */
    public fun clearError() {
      _builder.clearError()
    }
  }
}
@kotlin.jvm.JvmSynthetic
public inline fun org.spikeboot.grpc.BookOuterClass.SucceedResponse.copy(block: org.spikeboot.grpc.SucceedResponseKt.Dsl.() -> kotlin.Unit): org.spikeboot.grpc.BookOuterClass.SucceedResponse =
  org.spikeboot.grpc.SucceedResponseKt.Dsl._create(this.toBuilder()).apply { block() }._build()