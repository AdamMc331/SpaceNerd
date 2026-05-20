package com.adammcneilly.spacenerd.data.astronauts.impl

import com.adammcneilly.spacenerd.core.datetime.DateTimeProvider
import com.adammcneilly.spacenerd.core.models.Astronaut
import com.adammcneilly.spacenerd.core.models.SyncStatus
import com.adammcneilly.spacenerd.data.astronauts.api.AstronautListRequest
import com.adammcneilly.spacenerd.data.astronauts.api.AstronautRepository
import com.adammcneilly.spacenerd.data.astronauts.api.local.LocalAstronautService
import com.adammcneilly.spacenerd.data.astronauts.api.remote.RemoteAstronautService
import com.adammcneilly.spacenerd.data.cache.CacheTimestampRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext
import kotlin.time.Duration.Companion.hours

class OfflineFirstAstronautRepository(
    private val localAstronautService: LocalAstronautService,
    private val remoteAstronautService: RemoteAstronautService,
    private val cacheTimestampRepository: CacheTimestampRepository,
    private val dateTimeProvider: DateTimeProvider,
) : AstronautRepository {
    private val mutableSyncStatus = MutableStateFlow(SyncStatus.None)
    override val syncStatus: Flow<SyncStatus> = mutableSyncStatus.asStateFlow()

    override fun getAstronaut(
        astronautId: String,
    ): Flow<Astronaut> {
        return localAstronautService.getAstronaut(astronautId)
    }

    override fun getAstronauts(
        request: AstronautListRequest,
    ): Flow<List<Astronaut>> {
        return localAstronautService.getAstronauts(request)
            .onStart {
                syncAstronautListIfNecessary(coroutineContext, request)
            }
    }

    private fun syncAstronautListIfNecessary(
        coroutineContext: CoroutineContext,
        request: AstronautListRequest,
    ) {
        CoroutineScope(coroutineContext).launch {
            val cacheKey = "$KEY_ASTRONAUT_PREFIX$request"

            val lastCache = cacheTimestampRepository.getCacheTimestamp(cacheKey)
            val now = dateTimeProvider.now()
            val cacheDuration = 1.hours

            when {
                lastCache == null -> {
                    setSyncStatus(SyncStatus.Initial)
                    requestAstronauts(request, cacheKey)
                }

                (now - lastCache) > cacheDuration -> {
                    setSyncStatus(SyncStatus.Refresh)
                    requestAstronauts(request, cacheKey)
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

    private suspend fun requestAstronauts(
        request: AstronautListRequest,
        cacheKey: String,
    ) {
        val response = remoteAstronautService.getAstronauts(request)

        val astronauts = response.getOrNull()
        if (astronauts != null) {
            localAstronautService.saveAstronauts(astronauts)
            cacheTimestampRepository.setCacheTimestamp(cacheKey)
            setSyncStatus(SyncStatus.None)
        }

        val error = response.exceptionOrNull()
        if (error != null) {
            // Need to log this somewhere
            println("Error fetching astronauts $request: $error")
            setSyncStatus(SyncStatus.None)
        }
    }

    companion object {
        private const val KEY_ASTRONAUT_PREFIX = "astronaut_"
    }
}
