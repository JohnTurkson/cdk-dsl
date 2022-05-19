package com.johnturkson.cdk.dsl.constructs

data class App internal constructor(
    val name: String,
    val stacks: MutableSet<Stack>,
) : software.amazon.awscdk.App()
