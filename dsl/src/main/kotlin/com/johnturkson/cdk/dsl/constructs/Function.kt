package com.johnturkson.cdk.dsl.constructs

import com.johnturkson.cdk.dsl.exported.ExportedFunction
import software.amazon.awscdk.services.lambda.FunctionProps

class Function internal constructor(
    val stack: Stack,
    val id: String,
) : software.amazon.awscdk.services.lambda.Function(stack, id, FunctionProps.builder().build()) {
    fun export(): ExportedFunction {
        return ExportedFunction(id)
    }
}
