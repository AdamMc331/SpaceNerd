package com.adammcneilly.spacenerd.data.launch.test

import com.adammcneilly.spacenerd.core.models.Launch
import com.adammcneilly.spacenerd.data.launch.api.LaunchListRequest
import com.adammcneilly.spacenerd.data.launch.api.LaunchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeLaunchRepository : LaunchRepository {
    val launchesByRequest: MutableMap<LaunchListRequest, List<Launch>> = mutableMapOf()
    val launchById: MutableMap<String, Launch> = mutableMapOf()

    override fun getLaunches(
        request: LaunchListRequest,
    ): Flow<List<Launch>> {
        return flowOf(launchesByRequest[request]!!)
    }

    override fun getLaunch(
        id: String,
    ): Flow<Launch> {
        return flowOf(launchById[id]!!)
    }
}
