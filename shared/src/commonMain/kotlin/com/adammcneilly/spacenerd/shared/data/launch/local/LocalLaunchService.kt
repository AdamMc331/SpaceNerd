package com.adammcneilly.spacenerd.shared.data.launch.local

import com.adammcneilly.spacenerd.shared.core.models.Launch
import com.adammcneilly.spacenerd.shared.data.launch.LaunchListRequest
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
