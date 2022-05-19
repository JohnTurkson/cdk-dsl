package com.johnturkson.cdk.dsl.constructs

data class Stack internal constructor(
    val parent: App,
    val name: String,
    val functions: MutableSet<Function>,
) : software.amazon.awscdk.Stack(parent, name)
