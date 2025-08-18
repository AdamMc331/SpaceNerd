package com.adammcneilly.spacenerd.data.stations.api

import com.adammcneilly.spacenerd.core.models.SpaceStation
import kotlinx.coroutines.flow.Flow

/**
 * Defines any data requests to retrieve space station information from one or many data sources.
 *
 * Each function in this interface should return a [Flow], that emits any time the corresponding
 * data changes.
 */
interface SpaceStationRepository {
    fun getStations(
        request: SpaceStationListRequest,
    ): Flow<List<SpaceStation>>
}
