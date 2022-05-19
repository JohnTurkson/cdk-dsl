package com.johnturkson.cdk.codegen

import com.google.devtools.ksp.KspExperimental
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider

@KspExperimental
class CdkProcessorProvider : SymbolProcessorProvider {
    override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor {
        return CdkProcessor(environment.codeGenerator, environment.logger, environment.options)
    }
}
