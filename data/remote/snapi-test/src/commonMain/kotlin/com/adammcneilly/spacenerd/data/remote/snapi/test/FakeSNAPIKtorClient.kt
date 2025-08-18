package com.adammcneilly.spacenerd.data.remote.snapi.test

import com.adammcneilly.spacenerd.data.remote.ktor.test.FakeKtorClient
import com.adammcneilly.spacenerd.data.remote.snapi.test.mocks.mockSnapiArticleListResponse

/**
 * This is an implementation of [FakeKtorClient] that mocks responses to the
 * Spaceflight News API.
 */
object FakeSNAPIKtorClient : FakeKtorClient(
    mockResponses = mapOf(
        "/articles" to mockSnapiArticleListResponse,
    ),
)
