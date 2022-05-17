package com.johnturkson.dsl.examples

import software.amazon.awscdk.CfnOutput
import software.amazon.awscdk.Stack
import software.amazon.awscdk.StackProps
import software.amazon.awscdk.services.lambda.*
import software.amazon.awscdk.services.lambda.Function
import software.amazon.awscdk.services.s3.Bucket
import software.constructs.Construct

class ExampleStack(
    parent: Construct,
    name: String,
    props: StackProps? = null,
) : Stack(parent, name, props) {
    init {
        val code = """function main() { console.log("Hello World") }"""
        val function = Function.Builder.create(this, "ExampleFunction")
            .runtime(Runtime.NODEJS_16_X)
            .handler("index.main")
            .code(Code.fromInline(code))
            .build()
        val addFunctionUrl = function.addFunctionUrl(
            FunctionUrlOptions.builder()
                .authType(FunctionUrlAuthType.NONE)
                .build()
        )
        CfnOutput.Builder.create(this, "ExampleFunctionUrl").value(addFunctionUrl.url).build()
        val bucket = Bucket.Builder.create(this, "ExampleBucket").build()
    }
}
