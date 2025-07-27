package com.adammcneilly.spacenerd.data.remote.ktor

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.statement.HttpResponse
import io.ktor.http.isSuccess

/**
 * Whenever we want to add params to a request, we just return a map of param
 * keys and values. The [BaseKtorClient] can map this to the request builder.
 */
private typealias RemoteParams = Map<String, Any?>

/**
 * Creates a default [httpClient] that can make requests to the supplied [baseUrl].
 *
 * You can either subclass this with a specific client type,
 * like `object GitHubClient : BaseKtorClient("https://api.github.com")`,
 * or repurpose this class to represent a specific client instead.
 */
open class BaseKtorClient(
    val baseUrl: String,
    val httpClient: HttpClient = defaultHttpClient(),
) {
    /**
     * A helper function to build the [baseUrl] and [endpoint] operation and performs a get request.
     * Will also pass in the supplied [params] as necessary.
     *
     * NOTE that it is expected for endpoint to begin with a forward slash (/), it is not automatically
     * included into the full URL.
     *
     * You can call this function to get a response typed to the given generic, like so:
     * val eventResult: Result<Event> = apiClient.getResponse<Event>(endpoint = "/events/123")
     */
    @Suppress("TooGenericExceptionCaught")
    suspend inline fun <reified T : Any> getResponse(
        endpoint: String,
        params: RemoteParams = emptyMap(),
    ): Result<T> {
        val url = "$baseUrl$endpoint"

        return try {
            val response: HttpResponse = httpClient
                .get(url) {
                    addParams(params)
                }

            if (response.status.isSuccess()) {
                Result.success(response.body())
            } else {
                throw ClientRequestException(response, "Request failed with status: ${response.status}")
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}

/**
 * Adds all of the [params] to this [HttpRequestBuilder] as long as they're not null.
 */
fun HttpRequestBuilder.addParams(
    params: RemoteParams,
) {
    params.forEach { (key, value) ->
        if (value != null) {
            this.parameter(key, value)
        }
    }
}
