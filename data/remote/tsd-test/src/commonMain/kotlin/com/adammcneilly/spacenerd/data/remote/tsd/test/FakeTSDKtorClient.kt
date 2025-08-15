package com.adammcneilly.spacenerd.data.remote.tsd.test

import com.adammcneilly.spacenerd.data.remote.ktor.test.FakeKtorClient
import com.adammcneilly.spacenerd.data.remote.tsd.test.mocks.mockTsdAgencyResponse
import com.adammcneilly.spacenerd.data.remote.tsd.test.mocks.mockTsdLaunchDetailResponse
import com.adammcneilly.spacenerd.data.remote.tsd.test.mocks.mockTsdLaunchListResponse
import com.adammcneilly.spacenerd.data.remote.tsd.test.mocks.mockTsdSpaceStationListResponse

object FakeTSDKtorClient : FakeKtorClient(
    mockResponses = mapOf(
        "/space_stations" to mockTsdSpaceStationListResponse,
        "/agencies/123" to mockTsdAgencyResponse,
        "/launches/upcoming" to mockTsdLaunchListResponse,
        "/launches/123" to mockTsdLaunchDetailResponse,
    ),
)
