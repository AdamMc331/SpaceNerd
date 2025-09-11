package com.adammcneilly.spacenerd.data.expeditions.impl

import com.adammcneilly.spacenerd.core.models.Expedition
import com.adammcneilly.spacenerd.data.cache.CacheTimestampRepository
import com.adammcneilly.spacenerd.data.expeditions.api.ExpeditionListRequest
import com.adammcneilly.spacenerd.data.expeditions.api.ExpeditionRepository
import com.adammcneilly.spacenerd.data.expeditions.api.local.LocalExpeditionService
import com.adammcneilly.spacenerd.data.expeditions.api.remote.RemoteExpeditionService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext
import kotlin.time.Duration.Companion.hours

class OfflineFirstExpeditionRepository(
    private val localExpeditionService: LocalExpeditionService,
    private val remoteExpeditionService: RemoteExpeditionService,
    private val cacheTimestampRepository: CacheTimestampRepository,
) : ExpeditionRepository {
    override fun getExpeditions(
        request: ExpeditionListRequest,
    ): Flow<List<Expedition>> {
        return localExpeditionService.getExpeditions(request)
            .onStart {
                CoroutineScope(coroutineContext).launch {
                    val cacheKey = "$CACHE_KEY_EXPEDITIONS_PREFIX$request"

                    val needsServerFetch = cacheTimestampRepository.shouldSyncWithServer(
                        key = cacheKey,
                        cacheDuration = 1.hours,
                    )

                    if (true) {
                        val response = remoteExpeditionService.getExpeditions(request)

                        val expeditions = response.getOrNull()
                        if (expeditions != null) {
                            localExpeditionService.saveExpeditions(expeditions)
                        }

                        val error = response.exceptionOrNull()
                        if (error != null) {
                            // Need to log this somewhere
                            println("Error fetching expeditions $request: $error")
                        }
                    }
                }
            }
    }

    companion object {
        internal const val CACHE_KEY_EXPEDITIONS_PREFIX = "expeditions_"
    }
}
