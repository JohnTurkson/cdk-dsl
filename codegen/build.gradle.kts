plugins {
    kotlin("jvm")
    id("com.google.devtools.ksp")
}

group = "com.johnturkson.cdk.codegen"
version = "1.0-SNAPSHOT"

dependencies {
    implementation("com.google.devtools.ksp:symbol-processing-api:1.6.21-1.0.5")
}
