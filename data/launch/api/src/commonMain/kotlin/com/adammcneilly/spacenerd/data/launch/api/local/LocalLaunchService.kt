package com.adammcneilly.spacenerd.data.launch.api.local

import com.adammcneilly.spacenerd.core.models.Launch
import com.adammcneilly.spacenerd.data.launch.api.LaunchListRequest
import kotlinx.coroutines.flow.Flow

interface LocalLaunchService {
    suspend fun saveLaunches(
        launches: List<Launch>,
    )

    fun getLaunches(
        request: LaunchListRequest,
    ): Flow<List<Launch>>

    fun getLaunch(
        id: String,
    ): Flow<Launch>
}
