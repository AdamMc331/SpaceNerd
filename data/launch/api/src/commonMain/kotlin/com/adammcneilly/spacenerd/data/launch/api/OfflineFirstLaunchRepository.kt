package com.adammcneilly.spacenerd.data.launch.api

import com.adammcneilly.spacenerd.core.datetime.TimeProvider
import com.adammcneilly.spacenerd.core.models.Launch
import com.adammcneilly.spacenerd.data.cache.api.CacheTimestampRepository
import com.adammcneilly.spacenerd.data.launch.api.OfflineFirstLaunchRepository.Companion.LAUNCH_LIST_THROTTLE_DURATION
import com.adammcneilly.spacenerd.data.launch.api.local.LocalLaunchService
import com.adammcneilly.spacenerd.data.launch.api.remote.RemoteLaunchService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onStart
import kotlin.time.Duration.Companion.hours

class OfflineFirstLaunchRepository(
    private val localLaunchService: LocalLaunchService,
    private val remoteLaunchService: RemoteLaunchService,
    private val cacheTimestampRepository: CacheTimestampRepository,
    private val timeProvider: TimeProvider,
) : LaunchRepository {
    override fun getLaunches(
        request: LaunchListRequest,
    ): Flow<List<Launch>> {
        return localLaunchService.getLaunches(request)
            .onStart {
                val needsServerRefresh = needsListServerRefresh(request)

                if (!needsServerRefresh) {
                    return@onStart
                }

                refreshLaunchListFromServer(request)
            }
    }

    /**
     * Determines if we should refresh the launch list from server
     * by comparing the time since the last launch list request cache
     * to the [LAUNCH_LIST_THROTTLE_DURATION].
     */
    private suspend fun needsListServerRefresh(
        request: LaunchListRequest,
    ): Boolean {
        val cacheKey = LAUNCH_CACHE_KEY_PREFIX + request.toString()
        val now = timeProvider.now()
        val lastRequestTime = cacheTimestampRepository.getLastFetchTime(cacheKey)

        return if (lastRequestTime == null) {
            true
        } else {
            val durationSinceLastRequest = (now - lastRequestTime)
            durationSinceLastRequest > LAUNCH_LIST_THROTTLE_DURATION
        }
    }

    @Suppress("ForbiddenComment")
    private suspend fun refreshLaunchListFromServer(
        request: LaunchListRequest,
    ) {
        val response = remoteLaunchService.getLaunches(request)

        val launches = response.getOrNull()
        if (launches != null) {
            localLaunchService.saveLaunches(launches)
        }

        val error = response.exceptionOrNull()
        if (error != null) {
            // TODO: Need to log this somewhere
            println("Error fetching launches for $request: $error")
        }
    }

    companion object {
        private val LAUNCH_LIST_THROTTLE_DURATION = 1.hours
        private const val LAUNCH_CACHE_KEY_PREFIX = "Launches_"
    }
}
