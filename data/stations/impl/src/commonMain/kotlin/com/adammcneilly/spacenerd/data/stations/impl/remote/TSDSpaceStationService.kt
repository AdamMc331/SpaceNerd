package com.adammcneilly.spacenerd.data.stations.impl.remote

import com.adammcneilly.spacenerd.core.models.SpaceStation
import com.adammcneilly.spacenerd.core.models.SpaceStationStatus
import com.adammcneilly.spacenerd.data.remote.ktor.BaseKtorClient
import com.adammcneilly.spacenerd.data.remote.tsd.dtos.TSDSpaceStationDetailDTO
import com.adammcneilly.spacenerd.data.remote.tsd.dtos.TSDSpaceStationListResponseDTO
import com.adammcneilly.spacenerd.data.remote.tsd.dtos.TSDSpaceStationSummaryDTO
import com.adammcneilly.spacenerd.data.stations.api.SpaceStationListRequest
import com.adammcneilly.spacenerd.data.stations.api.remote.RemoteSpaceStationService

/**
 * This is an implementation of [RemoteSpaceStationService] that requests data from a TSD [client].
 *
 * We ensure the type is [BaseKtorClient] so we can supply a mock during tests.
 */
class TSDSpaceStationService(
    private val client: BaseKtorClient,
) : RemoteSpaceStationService {
    override suspend fun getStations(
        request: SpaceStationListRequest,
    ): Result<List<SpaceStation>> {
        return client.getResponse<TSDSpaceStationListResponseDTO>(
            endpoint = "space_stations",
            params = mapOf(
                "status" to request.status?.toTsdId(),
            ),
        ).map { listDto ->
            listDto.results?.map(TSDSpaceStationSummaryDTO::toSpaceStation).orEmpty()
        }
    }

    override suspend fun getStation(
        id: String,
    ): Result<SpaceStation> {
        return client.getResponse<TSDSpaceStationDetailDTO>(
            endpoint = "space_stations/$id",
        ).map(TSDSpaceStationDetailDTO::toSpaceStation)
    }
}

@Suppress("MagicNumber")
private fun SpaceStationStatus.toTsdId(): Int? {
    return when (this) {
        SpaceStationStatus.Active -> 1
        SpaceStationStatus.DeOrbited -> 2
        SpaceStationStatus.Decommissioned -> 3
        else -> null
    }
}
