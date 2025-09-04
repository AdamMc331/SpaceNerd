package com.adammcneilly.spacenerd.data.launch.impl.remote.tsd

import com.adammcneilly.spacenerd.core.models.Launch
import com.adammcneilly.spacenerd.data.launch.api.LaunchListRequest
import com.adammcneilly.spacenerd.data.launch.api.remote.RemoteLaunchService
import com.adammcneilly.spacenerd.data.remote.ktor.BaseKtorClient
import com.adammcneilly.spacenerd.data.remote.tsd.dtos.TSDLaunchDTO
import com.adammcneilly.spacenerd.data.remote.tsd.dtos.TSDLaunchListResponseDTO
import kotlin.time.ExperimentalTime

/**
 * This is an implementation of [RemoteLaunchService] that requests data from a TSD [client].
 *
 * We ensure the type is [BaseKtorClient] so we can supply a mock during tests.
 */
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
                "is_crewed" to request.hasCrew,
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
            // NOTE: adam-mcneilly delete before merging
            params = mapOf(
                "is_crewed" to true,
            ),
        ).map { launchListResponseDTO ->
            launchListResponseDTO.results?.map { launchDTO ->
                launchDTO.toLaunch()
            }.orEmpty()
        }
    }
}
