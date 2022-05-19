package com.johnturkson.cdk.dsl.constructs

import software.amazon.awscdk.services.lambda.FunctionProps

data class Function internal constructor(
    val parent: Stack,
    val id: String,
) : software.amazon.awscdk.services.lambda.Function(parent, id, FunctionProps.builder().build())
