package com.adammcneilly.spacenerd.data.remote.ktor.test

import com.adammcneilly.spacenerd.data.remote.ktor.BaseKtorClient

/**
 * This defines a fake implementation of [BaseKtorClient] for any given API.
 * The [mockResponses] map is a key value pair of an endpoint to a JSON response
 * for that endpoint.
 */
open class FakeKtorClient(
    mockResponses: Map<String, String> = emptyMap(),
) : BaseKtorClient(
        baseUrl = "",
        httpClient = fakeHttpClient(mockResponses),
    )
