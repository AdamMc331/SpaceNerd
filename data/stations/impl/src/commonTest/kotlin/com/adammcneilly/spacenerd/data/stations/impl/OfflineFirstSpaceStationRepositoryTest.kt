package com.adammcneilly.spacenerd.data.stations.impl

import com.adammcneilly.spacenerd.data.cache.test.FakeCacheTimestampRepository
import com.adammcneilly.spacenerd.data.stations.test.local.FakeLocalSpaceStationService
import com.adammcneilly.spacenerd.data.stations.test.remote.FakeRemoteSpaceStationService

class OfflineFirstSpaceStationRepositoryTest {
    private val localSpaceStationService = FakeLocalSpaceStationService()
    private val remoteSpaceStationService = FakeRemoteSpaceStationService()
    private val fakeCacheTimestampRepository = FakeCacheTimestampRepository()

    private val repository = OfflineFirstSpaceStationRepository(
        localSpaceStationService = localSpaceStationService,
        remoteSpaceStationService = remoteSpaceStationService,
        cacheTimestampRepository = fakeCacheTimestampRepository,
    )
}
