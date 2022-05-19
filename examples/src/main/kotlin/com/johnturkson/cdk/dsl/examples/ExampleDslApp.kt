package com.johnturkson.cdk.dsl.examples

import com.johnturkson.cdk.dsl.App
import com.johnturkson.cdk.dsl.Function
import com.johnturkson.cdk.dsl.Stack
import com.johnturkson.cdk.dsl.extensions.import
import software.amazon.awscdk.App
import software.amazon.awscdk.Stack
import software.amazon.awscdk.services.s3.Bucket

fun main() {
    val app = App("ExampleApp") {
        name = "ExampleAppOverride"

        val stack = Stack("ExampleFunction") {
            name = "ExampleStackOverride"

            val function = Function("ExampleFunction") {
                id = "ExampleFunctionOverride"
            }
        }
    }

    val stack = Stack(app, "ExampleStack") {
        name = "ExampleStackOverride"

        val function = Function("ExampleFunction") {
            id = "ExampleFunctionOverride"
        }
    }

    val function = Function(stack, "ExampleFunction") {
        id = "ExampleFunctionOverride"
    }

    Bucket.Builder.create(stack, "Bucket").build()

    app.synth()
}

fun test() {
    val app = App()
    val stack = Stack(app, "")

    val function = Function {

    }

    // stack[function, function]

    stack.import(function, function, function)
    // stack.import[function, function, function]
    // stack.import()

    // stack import function

    // stack import function
    // stack.import(function)
}

fun test2() {

    val function = Function {

    }

    val stack = Stack {
        // stack import function
        // import[function]
        // import(function)
        // import(function1, function2, function3, function4)
        // import {
        //     - function1
        //     - function2
        //     function3 // difficult to disallow this syntax
        // }

        import(function, function)
    }
    val app = App {
        import(stack)
    }
}

fun test3() {
    val stack = Stack {
        Function {
            
        }
    }
    
    
    val app = App()
    app.import(stack)
}

// infix fun Stack.import(function: FunctionBuilder) {
//
// }
//
// operator fun Stack.get(vararg functions: FunctionBuilder) {
//    
// }
