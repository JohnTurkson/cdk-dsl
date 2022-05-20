package com.johnturkson.cdk.dsl.exported

import kotlinx.serialization.Serializable

@Serializable
data class ExportedStack(
    val name: String,
    val functions: Set<ExportedFunction>,
    val buckets: Set<ExportedBucket>,
)
