package com.johnturkson.cdk.dsl.extensions

import com.johnturkson.cdk.dsl.builders.StackBuilder
import software.amazon.awscdk.App

fun App.import(vararg items: StackBuilder) {
    items.forEach { item ->
        // TODO handle Stack Props
        software.amazon.awscdk.Stack(this, item.name, null)
    }
}
