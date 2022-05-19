package com.johnturkson.cdk.dsl.builders

import com.johnturkson.cdk.dsl.annotations.CdkDslMarker
import com.johnturkson.cdk.dsl.constructs.Function
import com.johnturkson.cdk.dsl.constructs.Stack

@CdkDslMarker
data class FunctionBuilder(var id: String? = null) {
    internal var stack: Stack? = null
    internal var parent: StackBuilder? = null

    internal fun build(): Function {
        val stack = stack ?: parent?.build() ?: throw Exception()
        val id = id ?: throw Exception()
        return Function(stack, id)
    }
}
