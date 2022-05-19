package com.johnturkson.cdk.dsl.builders

import com.johnturkson.cdk.dsl.annotations.CdkDslMarker
import com.johnturkson.cdk.dsl.constructs.App
import com.johnturkson.cdk.dsl.constructs.Function
import com.johnturkson.cdk.dsl.constructs.Stack

@CdkDslMarker
data class StackBuilder(var name: String? = null) {
    internal var app: App? = null
    internal var parent: AppBuilder? = null
    internal val functions: MutableSet<FunctionBuilder> = mutableSetOf()

    internal fun build(): Stack {
        val app = app ?: parent?.build() ?: throw Exception()
        val name = name ?: throw Exception()
        val functions = functions.map { function -> function.build() }.toMutableSet()
        return Stack(app, name, functions)
    }
    
    fun import(vararg items: FunctionBuilder) {
        functions += items
    }

    fun Function(id: String? = null, create: FunctionBuilder.() -> Unit): Function {
        val builder = FunctionBuilder(id)
        builder.parent = this
        builder.create()
        val function = builder.build()
        functions += builder
        return function
    }
}
