package com.adammcneilly.spacenerd.data.stations.api.local

import com.adammcneilly.spacenerd.core.models.SpaceStation
import com.adammcneilly.spacenerd.data.stations.api.SpaceStationListRequest
import kotlinx.coroutines.flow.Flow

/**
 * This is a data source that requests space station information from a local data source.
 *
 * All functions should return a [Flow] that emits any time the local data source changes.
 * Any functions to save data should be suspending and operate on a background thread.
 */
interface LocalSpaceStationService {
    suspend fun saveStations(
        stations: List<SpaceStation>,
    )

    fun getStations(
        request: SpaceStationListRequest,
    ): Flow<List<SpaceStation>>
}
