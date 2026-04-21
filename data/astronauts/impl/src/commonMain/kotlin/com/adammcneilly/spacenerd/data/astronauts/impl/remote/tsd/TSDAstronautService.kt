package com.adammcneilly.spacenerd.data.astronauts.impl.remote.tsd

import com.adammcneilly.spacenerd.core.models.Astronaut
import com.adammcneilly.spacenerd.data.astronauts.api.AstronautListRequest
import com.adammcneilly.spacenerd.data.astronauts.api.remote.RemoteAstronautService
import com.adammcneilly.spacenerd.data.remote.ktor.BaseKtorClient
import com.adammcneilly.spacenerd.data.remote.tsd.dtos.TSDAstronautListResponseDTO

class TSDAstronautService(
    private val client: BaseKtorClient,
) : RemoteAstronautService {
    override suspend fun getAstronauts(
        request: AstronautListRequest,
    ): Result<List<Astronaut>> {
        return client.getResponse<TSDAstronautListResponseDTO>(
            endpoint = "astronauts",
            params = mapOf(
                "in_space" to request.inSpace,
            ),
        ).map { astronautListReponseDto ->
            astronautListReponseDto.results?.map { astronautDTO ->
                astronautDTO.toAstronaut()
            }.orEmpty()
        }
    }
}
