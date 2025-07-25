package com.adammcneilly.spacenerd.data.remote.ktor.test

import com.adammcneilly.spacenerd.data.remote.ktor.BaseKtorClient

open class FakeKtorClient(
    mockResponses: Map<String, String> = emptyMap(),
) : BaseKtorClient(
        baseUrl = "",
        httpClient = fakeHttpClient(mockResponses),
    )
