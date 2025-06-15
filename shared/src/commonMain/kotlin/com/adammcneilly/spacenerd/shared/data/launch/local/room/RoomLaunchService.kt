package com.adammcneilly.spacenerd.shared.data.launch.local.room

import com.adammcneilly.spacenerd.shared.core.models.Launch
import com.adammcneilly.spacenerd.shared.data.launch.LaunchListRequest
import com.adammcneilly.spacenerd.shared.data.launch.local.LocalLaunchService
import com.adammcneilly.spacenerd.shared.data.launch.local.room.dto.RoomLaunchDetailDTO
import com.adammcneilly.spacenerd.shared.datetime.DateTimeProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlin.time.Duration.Companion.hours

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
