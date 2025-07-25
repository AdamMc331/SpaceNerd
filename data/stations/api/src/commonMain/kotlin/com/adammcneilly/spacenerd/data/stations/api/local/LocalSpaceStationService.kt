package com.adammcneilly.spacenerd.data.stations.api.local

import com.adammcneilly.spacenerd.core.models.SpaceStation
import com.adammcneilly.spacenerd.data.stations.api.SpaceStationListRequest
import kotlinx.coroutines.flow.Flow

interface LocalSpaceStationService {
    suspend fun saveStations(
        stations: List<SpaceStation>,
    )

    fun getStations(
        request: SpaceStationListRequest,
    ): Flow<List<SpaceStation>>
}
