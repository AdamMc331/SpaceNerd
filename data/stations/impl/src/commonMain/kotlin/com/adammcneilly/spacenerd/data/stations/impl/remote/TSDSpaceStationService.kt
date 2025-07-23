package com.adammcneilly.spacenerd.data.stations.impl.remote

import com.adammcneilly.spacenerd.core.models.SpaceStation
import com.adammcneilly.spacenerd.data.remote.ktor.BaseKtorClient
import com.adammcneilly.spacenerd.data.remote.tsd.dtos.TSDSpaceStationDTO
import com.adammcneilly.spacenerd.data.remote.tsd.dtos.TSDSpaceStationListResponseDTO
import com.adammcneilly.spacenerd.data.stations.api.SpaceStationListRequest
import com.adammcneilly.spacenerd.data.stations.api.remote.RemoteSpaceStationService

class TSDSpaceStationService(
    private val client: BaseKtorClient,
) : RemoteSpaceStationService {
    override suspend fun getStations(
        request: SpaceStationListRequest,
    ): Result<List<SpaceStation>> {
        return client.getResponse<TSDSpaceStationListResponseDTO>(
            endpoint = "space_stations",
        ).map { listDto ->
            listDto.results?.map(TSDSpaceStationDTO::toSpaceStation).orEmpty()
        }
    }
}
