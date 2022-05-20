package com.johnturkson.cdk.dsl.examples

import software.amazon.awscdk.CfnOutput
import software.amazon.awscdk.Stack
import software.amazon.awscdk.StackProps
import software.amazon.awscdk.services.lambda.*
import software.amazon.awscdk.services.lambda.Function
import software.amazon.awscdk.services.s3.Bucket
import software.constructs.Construct

class ExampleCdkStack(
    parent: Construct,
    name: String,
    props: StackProps? = null,
) : Stack(parent, name, props) {
    init {
        val code = """def main(event, context):
            |    return "Hello World"
        """.trimMargin()
        val function = Function.Builder.create(this, "ExampleFunction")
            .runtime(Runtime.PYTHON_3_9)
            .handler("index.main")
            .code(Code.fromInline(code))
            .build()
        val addFunctionUrl = function.addFunctionUrl(
            FunctionUrlOptions.builder()
                .authType(FunctionUrlAuthType.NONE)
                .build()
        )
        CfnOutput.Builder.create(this, "ExampleFunctionUrl").value(addFunctionUrl.url)
            .exportName("exportedFunctionUrl")
            .build()
        
        val function2 = Function.Builder.create(this, "ExampleFunction2")
            .runtime(Runtime.PYTHON_3_9)
            .handler("index.main")
            .code(Code.fromInline(code))
            .build()
        function2.addEnvironment("URL", addFunctionUrl.url)
    }
}
