package com.adammcneilly.spacenerd.data.launch.impl.local.room

import com.adammcneilly.spacenerd.core.datetime.DateTimeProvider
import com.adammcneilly.spacenerd.core.models.Launch
import com.adammcneilly.spacenerd.data.launch.api.LaunchListRequest
import com.adammcneilly.spacenerd.data.launch.api.local.LocalLaunchService
import com.adammcneilly.spacenerd.data.local.room.daos.RoomLaunchDao
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomLaunchDetailDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlin.time.Duration.Companion.hours
import kotlin.time.ExperimentalTime

/**
 * This is an implementation of [LocalLaunchService] that requests data from a Room [launchDao].
 */
@OptIn(ExperimentalTime::class)
class RoomLaunchService(
    private val launchDao: RoomLaunchDao,
    private val dateTimeProvider: DateTimeProvider,
) : LocalLaunchService {
    override suspend fun saveLaunches(
        launches: List<Launch>,
    ) {
        launchDao.insertDomainLaunches(launches)
    }

    override fun getLaunches(
        request: LaunchListRequest,
    ): Flow<List<Launch>> {
        return when (request) {
            is LaunchListRequest.Custom -> {
                getCustomLaunches(request)
            }
            LaunchListRequest.Upcoming -> {
                getUpcomingLaunches()
            }
        }
    }

    override fun getLaunch(
        id: String,
    ): Flow<Launch> {
        return launchDao.getLaunch(id).map(RoomLaunchDetailDTO::toLaunch)
    }

    private fun getUpcomingLaunches(): Flow<List<Launch>> {
        val startTime = dateTimeProvider.now().minus(24.hours)

        return launchDao.getLaunches(
            before = null,
            after = startTime.toString(),
        ).map { launchDetailDTOList ->
            launchDetailDTOList.map(RoomLaunchDetailDTO::toLaunch)
        }
    }

    private fun getCustomLaunches(
        request: LaunchListRequest.Custom,
    ): Flow<List<Launch>> {
        return launchDao.getLaunches(
            before = request.before?.toString(),
            after = request.after?.toString(),
        ).map { launchDetailDTOList ->
            launchDetailDTOList.map(RoomLaunchDetailDTO::toLaunch)
        }
    }
}
