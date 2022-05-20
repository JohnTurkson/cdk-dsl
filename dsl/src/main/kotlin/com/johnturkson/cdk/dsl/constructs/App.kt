package com.johnturkson.cdk.dsl.constructs

import com.johnturkson.cdk.dsl.exported.ExportedApp

class App internal constructor(
    val name: String,
    internal val stacks: MutableSet<Stack> = mutableSetOf(),
) : software.amazon.awscdk.App() {
    fun export(): ExportedApp {
        return ExportedApp(name, stacks.map { stack -> stack.export() }.toSet())
    }
}
