package com.adammcneilly.spacenerd.data.launch.impl.local.room

import com.adammcneilly.spacenerd.core.models.Launch
import com.adammcneilly.spacenerd.data.launch.api.LaunchListRequest
import com.adammcneilly.spacenerd.data.launch.api.local.LocalLaunchService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RoomLaunchService(
    private val dao: LaunchDao,
) : LocalLaunchService {
    override suspend fun saveLaunches(
        launches: List<Launch>,
    ) {
        val dtos = launches.map(::RoomLaunchDTO)

        dao.insertLaunches(dtos)
    }

    override fun getLaunches(
        request: LaunchListRequest,
    ): Flow<List<Launch>> {
        return dao.getLaunches(
            before = request.before.toString(),
            after = request.after.toString(),
        ).map { dtoList ->
            dtoList.map(RoomLaunchDTO::toLaunch)
        }
    }
}
