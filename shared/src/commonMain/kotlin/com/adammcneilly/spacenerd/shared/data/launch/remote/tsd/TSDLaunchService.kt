package com.adammcneilly.spacenerd.shared.data.launch.remote.tsd

import com.adammcneilly.spacenerd.shared.core.models.Launch
import com.adammcneilly.spacenerd.shared.data.launch.LaunchListRequest
import com.adammcneilly.spacenerd.shared.data.launch.remote.RemoteLaunchService
import com.adammcneilly.spacenerd.shared.data.launch.remote.tsd.dto.TSDLaunchDTO
import com.adammcneilly.spacenerd.shared.data.launch.remote.tsd.dto.TSDLaunchListResponseDTO
import com.adammcneilly.spacenerd.shared.data.remote.ktor.BaseKtorClient

class TSDLaunchService(
    private val client: BaseKtorClient,
) : RemoteLaunchService {
    override suspend fun getLaunches(
        request: LaunchListRequest,
    ): Result<List<Launch>> {
        return when (request) {
            is LaunchListRequest.Custom -> {
                getCustomLaunches(request)
            }
            LaunchListRequest.Upcoming -> {
                getUpcomingLaunches()
            }
        }
    }

    override suspend fun getLaunch(
        id: String,
    ): Result<Launch> {
        val endpoint = "launches/$id"

        return client.getResponse<TSDLaunchDTO>(
            endpoint = endpoint,
        ).map(TSDLaunchDTO::toLaunch)
    }

    private suspend fun getCustomLaunches(
        request: LaunchListRequest.Custom,
    ): Result<List<Launch>> {
        return client.getResponse<TSDLaunchListResponseDTO>(
            endpoint = "launches",
            params = mapOf(
                "net__gte" to request.after,
                "net__lte" to request.before,
            ),
        ).map { launchListResponseDTO ->
            launchListResponseDTO.results?.map { launchDTO ->
                launchDTO.toLaunch()
            }.orEmpty()
        }
    }

    private suspend fun getUpcomingLaunches(): Result<List<Launch>> {
        return client.getResponse<TSDLaunchListResponseDTO>(
            endpoint = "launches/upcoming",
        ).map { launchListResponseDTO ->
            launchListResponseDTO.results?.map { launchDTO ->
                launchDTO.toLaunch()
            }.orEmpty()
        }
    }
}
