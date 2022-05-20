package com.johnturkson.cdk.dsl.builders

import com.johnturkson.cdk.dsl.annotations.CdkDslMarker
import com.johnturkson.cdk.dsl.constructs.Function
import com.johnturkson.cdk.dsl.constructs.Stack
import kotlinx.serialization.Serializable

@Serializable
@CdkDslMarker
data class FunctionBuilder(var id: String? = null) {

    internal fun build(stack: Stack): Function {
        val id = id ?: throw Exception()
        return Function(stack, id)
    }
}
