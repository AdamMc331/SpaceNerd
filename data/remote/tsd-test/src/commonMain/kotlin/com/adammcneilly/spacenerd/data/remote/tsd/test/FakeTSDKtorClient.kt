package com.adammcneilly.spacenerd.data.remote.tsd.test

import com.adammcneilly.spacenerd.data.remote.ktor.test.FakeKtorClient
import com.adammcneilly.spacenerd.data.remote.tsd.test.mocks.mockTsdSpaceStationListResponse

object FakeTSDKtorClient : FakeKtorClient(
    mockResponses = mapOf(
        "/space_stations" to mockTsdSpaceStationListResponse,
    ),
)
