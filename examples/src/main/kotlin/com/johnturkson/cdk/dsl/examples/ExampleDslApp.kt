package com.johnturkson.cdk.dsl.examples

import com.johnturkson.cdk.dsl.App
import com.johnturkson.cdk.dsl.Function
import com.johnturkson.cdk.dsl.Stack
import com.johnturkson.cdk.dsl.exported.ExportedApp
import com.johnturkson.cdk.dsl.extensions.import
import kotlinx.serialization.json.Json
import software.amazon.awscdk.Stack
import software.amazon.awscdk.services.s3.Bucket

fun main() {
    // val app = App("ExampleApp") {
    //     name = "ExampleAppOverride"
    //
    //     // val stack = Stack("ExampleFunction") {
    //     //     name = "ExampleStackOverride"
    //     //
    //     //     val function = Function("ExampleFunction") {
    //     //         id = "ExampleFunctionOverride"
    //     //     }
    //     // }
    // }
    //
    // val stack = Stack(app, "ExampleStack") {
    //     name = "ExampleStackOverride"
    //
    //     val function = Function("ExampleFunction") {
    //         id = "ExampleFunctionOverride"
    //     }
    // }
    //
    // val function = Function(stack, "ExampleFunction") {
    //     id = "ExampleFunctionOverride"
    // }
    //
    // Bucket.Builder.create(stack, "Bucket").build()

    // app.synth()

    // println(Json.encodeToString(ExportedApp.serializer(), app.export()))
    
    test2()
    // test3()
}

fun test() {
    val app = software.amazon.awscdk.App()
    val stack = Stack(app, "")

    val function = Function {

    }
    
    stack.import(function)

    // stack[function, function]

    // stack.import[function, function, function]
    // stack.import()

    // stack import function

    // stack import function
    // stack.import(function)
}

fun test2() {

    val function = Function("Test2Function") {

    }

    val stack = Stack("Test2Stack") {
        // stack import function
        // import[function]
        // import(function)
        // import(function1, function2, function3, function4)
        // import {
        //     - function1
        //     - function2
        //     function3 // difficult to disallow this syntax
        // }

        import(function)
    }

    val app = App {
        name = "Test2App"
        import(stack)
    }
    
    println(Json.encodeToString(ExportedApp.serializer(), app.export()))
}

fun test3() {
    val stack = Stack {
        val function = Function {
            
        }
    }
    
    
    val app = software.amazon.awscdk.App()
    app.import(stack)
}

// infix fun Stack.import(function: FunctionBuilder) {
//
// }
//
// operator fun Stack.get(vararg functions: FunctionBuilder) {
//    
// }
