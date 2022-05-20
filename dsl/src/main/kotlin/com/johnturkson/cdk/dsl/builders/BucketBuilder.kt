package com.johnturkson.cdk.dsl.builders

import com.johnturkson.cdk.dsl.annotations.CdkDslMarker
import com.johnturkson.cdk.dsl.constructs.Bucket
import com.johnturkson.cdk.dsl.constructs.Stack
import kotlinx.serialization.Serializable

@Serializable
@CdkDslMarker
data class BucketBuilder(var id: String? = null) {
    fun build(stack: Stack): Bucket {
        val id = id ?: throw Exception()
        return Bucket(stack, id)
    }
}
