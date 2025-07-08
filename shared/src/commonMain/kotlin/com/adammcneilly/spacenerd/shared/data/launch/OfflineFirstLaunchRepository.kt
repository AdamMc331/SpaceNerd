package com.adammcneilly.spacenerd.shared.data.launch

import com.adammcneilly.spacenerd.shared.core.models.Launch
import com.adammcneilly.spacenerd.shared.data.agency.local.LocalAgencyService
import com.adammcneilly.spacenerd.shared.data.agency.remote.RemoteAgencyService
import com.adammcneilly.spacenerd.shared.data.cache.CacheTimestampRepository
import com.adammcneilly.spacenerd.shared.data.launch.local.LocalLaunchService
import com.adammcneilly.spacenerd.shared.data.launch.remote.RemoteLaunchService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext
import kotlin.time.Duration.Companion.hours

class OfflineFirstLaunchRepository(
    private val localLaunchService: LocalLaunchService,
    private val remoteLaunchService: RemoteLaunchService,
    private val cacheTimestampRepository: CacheTimestampRepository,
    private val localAgencyService: LocalAgencyService,
    private val remoteAgencyService: RemoteAgencyService,
) : LaunchRepository {
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
            .onEach { launch ->
                val agencyId = launch.agency?.id ?: return@onEach

                syncAgencyIfNecessary(coroutineContext, agencyId)
            }
            .onStart {
                // Commenting this out for now, we don't learn anything new from
                // detail, currently.
//                syncLaunchIfNecessary(coroutineContext, id)
            }
    }

    private fun syncAgencyIfNecessary(
        coroutineContext: CoroutineContext,
        agencyId: String,
    ) {
        CoroutineScope(coroutineContext).launch {
            val cacheKey = "${CacheTimestampRepository.KEY_AGENCY_PREFIX}$agencyId"

            val needsServerFetch = cacheTimestampRepository.shouldSyncWithServer(
                key = cacheKey,
                cacheDuration = 1.hours,
            )

            if (needsServerFetch) {
                val response = remoteAgencyService.getAgency(agencyId)

                val agency = response.getOrNull()
                if (agency != null) {
                    localAgencyService.saveAgency(agency)
                    cacheTimestampRepository.setCacheTimestamp(cacheKey)
                }

                val error = response.exceptionOrNull()
                if (error != null) {
                    // Need to log this somewhere
                    println("Error fetching agency $agencyId: $error")
                }
            }
        }
    }

    private fun syncLaunchListIfNecessary(
        coroutineContext: CoroutineContext,
        request: LaunchListRequest,
    ) {
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

    @Suppress("UnusedPrivateMember")
    private fun syncLaunchIfNecessary(
        coroutineContext: CoroutineContext,
        id: String,
    ) {
        CoroutineScope(coroutineContext).launch {
            val cacheKey = "${CacheTimestampRepository.KEY_LAUNCH_PREFIX}$id"

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
