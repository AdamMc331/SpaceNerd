package com.adammcneilly.spacenerd.shared.data.launch

import com.adammcneilly.spacenerd.shared.core.models.Launch
import com.adammcneilly.spacenerd.shared.data.cache.CacheTimestampRepository
import com.adammcneilly.spacenerd.shared.data.launch.local.LocalLaunchService
import com.adammcneilly.spacenerd.shared.data.launch.remote.RemoteLaunchService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext
import kotlin.time.Duration.Companion.hours

class OfflineFirstLaunchRepository(
    private val localLaunchService: LocalLaunchService,
    private val remoteLaunchService: RemoteLaunchService,
    private val cacheTimestampRepository: CacheTimestampRepository,
) : LaunchRepository {
    override fun getLaunches(
        request: LaunchListRequest,
    ): Flow<List<Launch>> {
        return localLaunchService.getLaunches(request)
            .onStart {
                CoroutineScope(coroutineContext).launch {
                    val cacheKey = "${CacheTimestampRepository.KEY_LAUNCHES_PREFIX}_$request"

                    val needsServerFetch = cacheTimestampRepository.shouldSyncWithServer(
                        key = cacheKey,
                        cacheDuration = 1.hours,
                    )

                    if (needsServerFetch) {
                        val response = remoteLaunchService.getLaunches(request)

                        val launches = response.getOrNull()
                        if (launches != null) {
                            localLaunchService.saveLaunches(launches)
                            cacheTimestampRepository.setCacheTimestamp(cacheKey)
                        }

                        val error = response.exceptionOrNull()
                        if (error != null) {
                            // Need to log this somewhere
                            println("Error fetching launches $request: $error")
                        }
                    }
                }
            }
    }

    override fun getLaunch(
        id: String,
    ): Flow<Launch> {
        return localLaunchService.getLaunch(id)
            .onStart {
                CoroutineScope(coroutineContext).launch {
                    val cacheKey = "${CacheTimestampRepository.KEY_LAUNCH_PREFIX}_$id"

                    val needsServerFetch = cacheTimestampRepository.shouldSyncWithServer(
                        key = cacheKey,
                        cacheDuration = 1.hours,
                    )

                    if (needsServerFetch) {
                        val response = remoteLaunchService.getLaunch(id)

                        val launch = response.getOrNull()
                        if (launch != null) {
                            localLaunchService.saveLaunches(listOf(launch))
                            cacheTimestampRepository.setCacheTimestamp(cacheKey)
                        }

                        val error = response.exceptionOrNull()
                        if (error != null) {
                            // Need to log this somewhere
                            println("Error fetching launch $id: $error")
                        }
                    }
                }
            }
    }
}
