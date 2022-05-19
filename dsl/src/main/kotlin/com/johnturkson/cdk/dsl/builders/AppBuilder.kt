package com.johnturkson.cdk.dsl.builders

import com.johnturkson.cdk.dsl.annotations.CdkDslMarker
import com.johnturkson.cdk.dsl.constructs.App
import com.johnturkson.cdk.dsl.constructs.Stack

@CdkDslMarker
data class AppBuilder(var name: String? = null) {
    internal val stacks: MutableSet<StackBuilder> = mutableSetOf()

    internal fun build(): App {
        val name = name ?: throw Exception()
        val stacks = stacks.map { stack -> stack.build() }.toMutableSet()
        return App(name, stacks)
    }
    
    fun import(vararg items: StackBuilder) {
        stacks += items
    }

    @Deprecated("", level = DeprecationLevel.ERROR)
    fun App(name: String? = null, create: AppBuilder.() -> Unit): App {
        throw Exception()
    }

    fun Stack(name: String? = null, create: StackBuilder.() -> Unit): Stack {
        val builder = StackBuilder(name)
        builder.parent = this
        builder.create()
        val stack = builder.build()
        stacks += builder
        return stack
    }
}
