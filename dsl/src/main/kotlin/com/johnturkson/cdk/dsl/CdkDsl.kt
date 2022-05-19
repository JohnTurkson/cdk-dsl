package com.johnturkson.cdk.dsl

import com.johnturkson.cdk.dsl.builders.AppBuilder
import com.johnturkson.cdk.dsl.builders.FunctionBuilder
import com.johnturkson.cdk.dsl.builders.StackBuilder
import com.johnturkson.cdk.dsl.constructs.App
import com.johnturkson.cdk.dsl.constructs.Stack
import software.amazon.awscdk.services.lambda.Function

fun App(
    name: String? = null,
    create: AppBuilder.() -> Unit,
): App {
    val builder = AppBuilder(name)
    builder.create()
    return builder.build()
}

fun Stack(
    app: App,
    name: String? = null,
    create: StackBuilder.() -> Unit,
): Stack {
    val builder = StackBuilder(name)
    builder.app = app
    builder.create()
    val stack = builder.build()
    app.stacks += stack
    return stack
}

fun Stack(
    app: AppBuilder,
    name: String? = null,
    create: StackBuilder.() -> Unit,
): Stack {
    val builder = StackBuilder(name)
    builder.parent = app
    builder.create()
    val stack = builder.build()
    app.stacks += builder
    return stack
}

fun Stack(
    name: String? = null,
    create: StackBuilder.() -> Unit,
): StackBuilder {
    val builder = StackBuilder(name)
    builder.create()
    return builder
}

fun Function(
    stack: Stack,
    id: String? = null,
    create: FunctionBuilder.() -> Unit,
): Function {
    val builder = FunctionBuilder(id)
    builder.stack = stack
    builder.create()
    val function = builder.build()
    stack.functions += function
    return function
}

fun Function(
    stack: StackBuilder,
    id: String? = null,
    create: FunctionBuilder.() -> Unit,
): Function {
    val builder = FunctionBuilder(id)
    builder.parent = stack
    builder.create()
    val function = builder.build()
    stack.functions += builder
    return function
}

fun Function(
    id: String? = null,
    create: FunctionBuilder.() -> Unit,
): FunctionBuilder {
    val builder = FunctionBuilder(id)
    builder.create()
    return builder
}
