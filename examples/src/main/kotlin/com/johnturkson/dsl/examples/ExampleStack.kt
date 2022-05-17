package com.johnturkson.dsl.examples

import software.amazon.awscdk.Stack
import software.amazon.awscdk.StackProps
import software.amazon.awscdk.services.lambda.Function
import software.amazon.awscdk.services.s3.Bucket
import software.constructs.Construct

class ExampleStack(
    parent: Construct,
    name: String,
    props: StackProps? = null,
) : Stack(parent, name, props) {
    init {
        Function.Builder.create(this, "")
        Bucket.Builder.create(this, "ExampleBucket").build()
    }
}
