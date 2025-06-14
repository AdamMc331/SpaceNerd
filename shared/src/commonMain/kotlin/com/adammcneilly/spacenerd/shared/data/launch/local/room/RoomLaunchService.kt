package com.adammcneilly.spacenerd.shared.data.launch.local.room

import com.adammcneilly.spacenerd.shared.core.models.Launch
import com.adammcneilly.spacenerd.shared.data.launch.LaunchListRequest
import com.adammcneilly.spacenerd.shared.data.launch.local.LocalLaunchService
import com.adammcneilly.spacenerd.shared.data.launch.local.room.dto.RoomLaunchDetailDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RoomLaunchService(
    private val launchDao: RoomLaunchDao,
) : LocalLaunchService {
    override suspend fun saveLaunches(
        launches: List<Launch>,
    ) {
        launchDao.insertLaunches(launches)
    }

    override fun getLaunches(
        request: LaunchListRequest,
    ): Flow<List<Launch>> {
        return launchDao.getLaunches(
            before = request.before?.toString(),
            after = request.after?.toString(),
        ).map { launchDetailDTOList ->
            launchDetailDTOList.map(RoomLaunchDetailDTO::toLaunch)
        }
    }
}
