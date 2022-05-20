package com.johnturkson.cdk.dsl.constructs

import com.johnturkson.cdk.dsl.exported.ExportedStack

class Stack internal constructor(
    app: App,
    val name: String,
    val functions: MutableSet<Function> = mutableSetOf(),
    val buckets: MutableSet<Bucket> = mutableSetOf(),
) : software.amazon.awscdk.Stack(app, name) {
    fun export(): ExportedStack {
        return ExportedStack(
            name,
            functions.map { function -> function.export() }.toSet(),
            buckets.map { bucket -> bucket.export() }.toSet()
        )
    }
}
