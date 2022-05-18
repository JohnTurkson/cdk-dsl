package com.johnturkson.cdk.dsl.examples

import software.amazon.awscdk.App
import software.amazon.awscdk.StackProps

fun main() {
    val app = App()
    // ExampleStack(app, "ExampleStack")

    // val app = App {
    //     Environment {
    //
    //     }
    //    
    //     val stack = Stack {
    //         Function {
    //            
    //         }
    //     }
    // }
    //
    // val stack = Stack(app) {
    //     Function {
    //
    //     }
    // }
    //
    // val function = Function(stack) {
    //    
    // }

    app.synth()
}
