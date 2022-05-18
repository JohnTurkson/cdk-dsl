package com.johnturkson.cdk.dsl

data class Function(val id: String)

@CdkDslMarker
class FunctionBuilder(var id: String? = null) {
    fun build(): Function {
        val id = id ?: throw Exception()
        return Function(id)
    }
}

fun Function(stack: StackBuilder, create: FunctionBuilder.() -> Unit): Function {
    return stack.Function(create)
}

data class Stack(val name: String)

@CdkDslMarker
class StackBuilder {
    private val functions: MutableSet<Function> = mutableSetOf()
    var name: String? = null

    fun build(): Stack {
        val name = name ?: throw Exception()
        return Stack(name)
    }

    fun Function(create: FunctionBuilder.() -> Unit): Function {
        val builder = FunctionBuilder()
        builder.create()
        val function = builder.build()
        functions += function
        return builder.build()
    }
}

fun Stack(app: AppBuilder, create: StackBuilder.() -> Unit): Stack {
    return app.Stack(create)
}

data class App(val name: String) : software.amazon.awscdk.App()

@CdkDslMarker
class AppBuilder {
    // TODO replace with Set<StackBuilder>
    private val stacks: MutableSet<Stack> = mutableSetOf()
    var name: String? = null

    fun build(): App {
        val name = name ?: throw Exception()
        return App(name)
    }

    fun Environment(create: EnvironmentBuilder.() -> Unit) {
        // TODO
    }

    fun Stack(create: StackBuilder.() -> Unit): Stack {
        val builder = StackBuilder()
        builder.create()
        stacks += builder.build()
        return builder.build()
    }

    @Deprecated("", level = DeprecationLevel.ERROR)
    fun App(create: AppBuilder.() -> Unit): App {
        throw Exception()
    }
}

@CdkDslMarker
class EnvironmentBuilder {

}

// TODO
class Environment

fun App(create: AppBuilder.() -> Unit): App {
    val builder = AppBuilder()
    builder.create()
    return builder.build()
}

val app = App {
    name = ""

    Environment {

    }

    val stack = Stack {
        name = ""

        Function {
            id = ""
        }
    }

    // import Stack stack
    // add Stack stack
    // use Stack stack
}

val stack = Stack(app) {
    name = ""
    val function = Function { 
        id = ""
    }
}

// val function = Function {
//     id = ""
// }
