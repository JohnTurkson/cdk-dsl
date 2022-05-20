package com.johnturkson.cdk.dsl.builders

import com.johnturkson.cdk.dsl.annotations.CdkDslMarker
import com.johnturkson.cdk.dsl.constructs.App
import kotlinx.serialization.Serializable

@Serializable
@CdkDslMarker
data class AppBuilder(var name: String? = null) {
    private val stacks: MutableSet<StackBuilder> = mutableSetOf()

    internal fun build(): App {
        val name = name ?: throw Exception()
        val app = App(name, mutableSetOf())
        val stacks = stacks.map { stack -> stack.build(app) }.toMutableSet()
        app.stacks += stacks
        return app
    }

    fun import(vararg items: StackBuilder) {
        stacks += items
    }

    @Deprecated("", level = DeprecationLevel.ERROR)
    fun App(name: String? = null, create: AppBuilder.() -> Unit): App {
        throw Exception()
    }

    fun Stack(name: String? = null, create: StackBuilder.() -> Unit): StackBuilder {
        val builder = StackBuilder(name)
        builder.create()
        stacks += builder
        return builder
    }
}
