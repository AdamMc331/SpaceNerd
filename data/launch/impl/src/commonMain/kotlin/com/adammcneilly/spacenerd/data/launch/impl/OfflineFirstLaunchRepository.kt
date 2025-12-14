package com.adammcneilly.spacenerd.data.launch.impl

import com.adammcneilly.spacenerd.core.datetime.DateTimeProvider
import com.adammcneilly.spacenerd.core.models.Launch
import com.adammcneilly.spacenerd.core.models.SyncStatus
import com.adammcneilly.spacenerd.data.cache.CacheTimestampRepository
import com.adammcneilly.spacenerd.data.launch.api.LaunchListRequest
import com.adammcneilly.spacenerd.data.launch.api.LaunchRepository
import com.adammcneilly.spacenerd.data.launch.api.local.LocalLaunchService
import com.adammcneilly.spacenerd.data.launch.api.remote.RemoteLaunchService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext
import kotlin.time.Duration.Companion.hours
import kotlin.time.ExperimentalTime

/**
 * This is an implementation of [LaunchRepository] that prioritizes offline data, using [localLaunchService]
 * as the source of truth, and only syncing with [remoteLaunchService] when necessary.
 */
@OptIn(ExperimentalTime::class)
class OfflineFirstLaunchRepository(
    private val localLaunchService: LocalLaunchService,
    private val remoteLaunchService: RemoteLaunchService,
    private val cacheTimestampRepository: CacheTimestampRepository,
    private val dateTimeProvider: DateTimeProvider,
) : LaunchRepository {
    private val mutableSyncStatus = MutableStateFlow(SyncStatus.None)
    override val syncStatus: Flow<SyncStatus> = mutableSyncStatus.asStateFlow()

    override fun getLaunches(
        request: LaunchListRequest,
    ): Flow<List<Launch>> {
        return localLaunchService.getLaunches(request)
            .onStart {
                syncLaunchListIfNecessary(coroutineContext, request)
            }
    }

    override fun getLaunch(
        id: String,
    ): Flow<Launch> {
        return localLaunchService.getLaunch(id)
    }

    private fun syncLaunchListIfNecessary(
        coroutineContext: CoroutineContext,
        request: LaunchListRequest,
    ) {
        CoroutineScope(coroutineContext).launch {
            val cacheKey = "$KEY_LAUNCH_PREFIX$request"

            val lastCache = cacheTimestampRepository.getCacheTimestamp(cacheKey)
            val now = dateTimeProvider.now()
            val cacheDuration = 1.hours

            when {
                lastCache == null -> {
                    setSyncStatus(SyncStatus.Initial)
                    requestLaunches(request, cacheKey)
                }

                (now - lastCache) > cacheDuration -> {
                    setSyncStatus(SyncStatus.Refresh)
                    requestLaunches(request, cacheKey)
                }

                else -> {
                    setSyncStatus(SyncStatus.None)
                }
            }
        }
    }

    private fun setSyncStatus(
        status: SyncStatus,
    ) {
        mutableSyncStatus.value = status
    }

    private suspend fun requestLaunches(
        request: LaunchListRequest,
        cacheKey: String,
    ) {
        val response = remoteLaunchService.getLaunches(request)

        val launches = response.getOrNull()
        if (launches != null) {
            localLaunchService.saveLaunches(launches)
            cacheTimestampRepository.setCacheTimestamp(cacheKey)
            setSyncStatus(SyncStatus.None)
        }

        val error = response.exceptionOrNull()
        if (error != null) {
            // Need to log this somewhere
            println("Error fetching launches $request: $error")
            setSyncStatus(SyncStatus.None)
        }
    }

    companion object {
        private const val KEY_LAUNCH_PREFIX = "launch_"
    }
}
