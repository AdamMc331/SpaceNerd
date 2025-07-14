package com.adammcneilly.spacenerd.shared.data.launch.remote

import com.adammcneilly.spacenerd.core.models.Launch
import com.adammcneilly.spacenerd.shared.data.launch.LaunchListRequest

interface RemoteLaunchService {
    suspend fun getLaunches(
        request: LaunchListRequest,
    ): Result<List<Launch>>

    suspend fun getLaunch(
        id: String,
    ): Result<Launch>
}
