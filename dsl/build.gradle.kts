plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    id("com.google.devtools.ksp")
    antlr
}

group = "com.johnturkson.cdk.dsl"
version = "1.0-SNAPSHOT"

dependencies {
    antlr("org.antlr:antlr4:4.10.1")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.3")
    implementation("software.amazon.awscdk:aws-cdk-lib:2.24.1")
}

kotlin {
    sourceSets {
        main {
            kotlin.srcDir("build/generated/ksp/main/kotlin")
        }
    }
}

ksp {
    arg("CDK_GENERATED_OUTPUT_LOCATION", "$group.generated")
}
