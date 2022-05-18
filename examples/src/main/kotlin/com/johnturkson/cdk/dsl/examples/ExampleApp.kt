package com.johnturkson.cdk.dsl.examples

import software.amazon.awscdk.App

fun main() {
    val app = App()
    ExampleStack(app, "ExampleStack")
    app.synth()
}
