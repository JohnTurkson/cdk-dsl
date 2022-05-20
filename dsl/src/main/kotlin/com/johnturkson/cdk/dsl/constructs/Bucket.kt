package com.johnturkson.cdk.dsl.constructs

import com.johnturkson.cdk.dsl.exported.ExportedBucket

class Bucket internal constructor(val stack: Stack, val id: String) {
    fun export(): ExportedBucket {
        return ExportedBucket(id)
    }
}
