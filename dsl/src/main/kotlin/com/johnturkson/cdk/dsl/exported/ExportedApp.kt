package com.johnturkson.cdk.dsl.exported

import kotlinx.serialization.Serializable

@Serializable
data class ExportedApp(val name: String, val stacks: Set<ExportedStack>)
