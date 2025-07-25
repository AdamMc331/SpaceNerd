package com.adammcneilly.spacenerd.data.remote.ktor

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.KotlinxSerializationConverter
import kotlinx.serialization.json.Json

/**
 * Creates the default [HttpClient] configuration which
 * will be supplied to a [BaseKtorClient].
 *
 * @param[engine] If null, we'll use the default engine from the available dependencies.
 * Otherwise, we will use the supplied engine. This is typically only supplied for unit tests,
 * where the engine can deliver mock responses.
 */
fun defaultHttpClient(
    engine: HttpClientEngine? = null,
): HttpClient {
    val configBlock: HttpClientConfig<*>.() -> Unit = {
        install(ContentNegotiation) {
            val converter = KotlinxSerializationConverter(
                Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                },
            )
            register(ContentType.Any, converter)
        }

        install(Logging) {
            logger = Logger.SIMPLE
            level = LogLevel.ALL
        }
    }

    return if (engine != null) {
        HttpClient(engine, configBlock)
    } else {
        HttpClient(configBlock)
    }
}
