package com.johnturkson.cdk.dsl.extensions

import com.johnturkson.cdk.dsl.builders.FunctionBuilder
import software.amazon.awscdk.Stack

fun Stack.import(vararg items: FunctionBuilder) {
    items.forEach { item ->
        // TODO move CDK Builder generation into Builder class
        software.amazon.awscdk.services.lambda.Function.Builder.create(this, item.id).build()
    }
}
