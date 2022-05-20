package com.johnturkson.cdk.dsl.builders

import com.johnturkson.cdk.dsl.annotations.CdkDslMarker
import com.johnturkson.cdk.dsl.constructs.App
import com.johnturkson.cdk.dsl.constructs.Stack
import kotlinx.serialization.Serializable

@Serializable
@CdkDslMarker
data class StackBuilder(var name: String? = null) {
    private val functions: MutableSet<FunctionBuilder> = mutableSetOf()
    private val buckets: MutableSet<BucketBuilder> = mutableSetOf()

    internal fun build(app: App): Stack {
        val name = name ?: throw Exception()
        val stack = Stack(app, name)
        val functions = functions.map { function -> function.build(stack) }.toMutableSet()
        val buckets = buckets.map { bucket -> bucket.build(stack) }.toMutableSet()
        stack.functions += functions
        stack.buckets += buckets
        return stack
    }

    fun import(vararg items: FunctionBuilder) {
        functions += items
    }

    fun Function(id: String? = null, create: FunctionBuilder.() -> Unit): FunctionBuilder {
        val builder = FunctionBuilder(id)
        builder.create()
        functions += builder
        return builder
    }
    
    fun Bucket(id: String? = null, create: BucketBuilder.() -> Unit): BucketBuilder {
        val builder = BucketBuilder(id)
        builder.create()
        buckets += builder
        return builder
    }
}
