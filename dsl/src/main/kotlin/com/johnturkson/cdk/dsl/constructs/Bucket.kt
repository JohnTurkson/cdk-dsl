package com.johnturkson.cdk.dsl.constructs

import com.johnturkson.cdk.dsl.exported.ExportedBucket

class Bucket internal constructor(
    val stack: Stack,
    val id: String,
) : software.amazon.awscdk.services.s3.Bucket(stack, id) {
    fun export(): ExportedBucket {
        return ExportedBucket(id)
    }
}
