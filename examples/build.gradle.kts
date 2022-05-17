plugins {
    kotlin("jvm")
    application
}

group = "com.johnturkson.cdk.examples"
version = "1.0-SNAPSHOT"

dependencies {
    implementation("software.amazon.awscdk:aws-cdk-lib:2.24.1")
}

application {
    mainClass.set("ExampleAppKt")
}
