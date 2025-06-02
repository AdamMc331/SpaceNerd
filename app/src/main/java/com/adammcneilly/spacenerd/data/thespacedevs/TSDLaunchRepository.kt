package com.adammcneilly.spacenerd.data.thespacedevs

import com.adammcneilly.spacenerd.core.models.Launch
import com.adammcneilly.spacenerd.data.models.LaunchListRequest
import com.adammcneilly.spacenerd.data.repositories.LaunchRepository
import com.adammcneilly.spacenerd.data.thespacedevs.dto.TSDLaunchDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TSDLaunchRepository @Inject constructor(
    private val api: TSDRetrofitAPI,
) : LaunchRepository {
    @Suppress("TooGenericExceptionCaught")
    override fun getLaunches(
        request: LaunchListRequest,
    ): Flow<List<Launch>> {
        return when (request) {
            is LaunchListRequest.Custom -> {
                requestCustomLaunches(request)
            }
            LaunchListRequest.Upcoming -> {
                return requestUpcomingLaunches()
            }
        }
    }

    private fun requestUpcomingLaunches(): Flow<List<Launch>> {
        return flow {
            try {
                val launches = api
                    .getUpcomingLaunches()
                    .results
                    ?.map(TSDLaunchDTO::toLaunch)
                    .orEmpty()

                emit(launches)
            } catch (e: Exception) {
                println("Unable to request launches: $e")
            }
        }
    }

    private fun requestCustomLaunches(
        request: LaunchListRequest.Custom,
    ): Flow<List<Launch>> {
        return flow {
            try {
                val launches = api
                    .getLaunches(
                        slug = request.slug,
                        before = request.before?.toString(),
                        after = request.after?.toString(),
                    )
                    .results
                    ?.map(TSDLaunchDTO::toLaunch)
                    .orEmpty()

                emit(launches)
            } catch (e: Exception) {
                println("Unable to request launches: $e")
            }
        }
    }
}
