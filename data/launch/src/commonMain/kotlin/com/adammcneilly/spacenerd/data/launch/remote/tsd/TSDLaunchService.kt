package com.adammcneilly.spacenerd.data.launch.remote.tsd

import com.adammcneilly.spacenerd.core.models.Launch
import com.adammcneilly.spacenerd.data.launch.LaunchListRequest
import com.adammcneilly.spacenerd.data.launch.remote.RemoteLaunchService
import com.adammcneilly.spacenerd.data.remote.ktor.BaseKtorClient
import com.adammcneilly.spacenerd.data.remote.tsd.dtos.TSDLaunchDTO
import com.adammcneilly.spacenerd.data.remote.tsd.dtos.TSDLaunchListResponseDTO
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
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
