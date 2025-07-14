package com.adammcneilly.spacenerd.shared.data.agency

import com.adammcneilly.spacenerd.core.models.Agency
import com.adammcneilly.spacenerd.shared.data.agency.local.LocalAgencyService
import com.adammcneilly.spacenerd.shared.data.agency.remote.RemoteAgencyService
import com.adammcneilly.spacenerd.shared.data.cache.CacheTimestampRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext
import kotlin.time.Duration.Companion.hours

class OfflineFirstAgencyRepository(
    private val localAgencyService: LocalAgencyService,
    private val remoteAgencyService: RemoteAgencyService,
    private val cacheTimestampRepository: CacheTimestampRepository,
) : AgencyRepository {
    override fun getAgency(
        id: String,
    ): Flow<Agency> {
        return localAgencyService.getAgency(id)
            .onStart {
                CoroutineScope(coroutineContext).launch {
                    val cacheKey = "${CacheTimestampRepository.KEY_AGENCY_PREFIX}$id"

                    val needsServerFetch = cacheTimestampRepository.shouldSyncWithServer(
                        key = cacheKey,
                        cacheDuration = 1.hours,
                    )

                    if (needsServerFetch) {
                        val response = remoteAgencyService.getAgency(id)

                        val agency = response.getOrNull()
                        if (agency != null) {
                            localAgencyService.saveAgency(agency)
                            cacheTimestampRepository.setCacheTimestamp(cacheKey)
                        }

                        val error = response.exceptionOrNull()
                        if (error != null) {
                            // Need to log this somewhere
                            println("Error fetching Agency $id: $error")
                        }
                    }
                }
            }
    }
}
