plugins {
    kotlin("jvm")
    id("com.google.devtools.ksp")
    application
}

group = "com.johnturkson.cdk.examples"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(project(":dsl"))
    implementation(project(":codegen"))
    ksp(project(":codegen"))
    implementation("software.amazon.awscdk:aws-cdk-lib:2.24.1")
}

application {
    mainClass.set("com.johnturkson.cdk.dsl.examples.ExampleDslAppKt")
}
