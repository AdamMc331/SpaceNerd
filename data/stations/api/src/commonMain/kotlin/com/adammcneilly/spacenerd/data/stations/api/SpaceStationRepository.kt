package com.adammcneilly.spacenerd.data.stations.api

import com.adammcneilly.spacenerd.core.models.SpaceStation
import kotlinx.coroutines.flow.Flow

interface SpaceStationRepository {
    fun getStations(
        request: SpaceStationListRequest,
    ): Flow<List<SpaceStation>>
}
