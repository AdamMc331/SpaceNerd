package com.adammcneilly.spacenerd.data.remote.snapi.test

import com.adammcneilly.spacenerd.data.remote.ktor.test.FakeKtorClient
import com.adammcneilly.spacenerd.data.remote.snapi.test.mocks.mockSnapiArticleListResponse

object FakeSNAPIKtorClient : FakeKtorClient(
    mockResponses = mapOf(
        "/v4/articles" to mockSnapiArticleListResponse,
    ),
)
