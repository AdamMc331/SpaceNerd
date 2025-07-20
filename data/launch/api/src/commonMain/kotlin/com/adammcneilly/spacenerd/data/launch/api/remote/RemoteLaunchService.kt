package com.adammcneilly.spacenerd.data.launch.api.remote

import com.adammcneilly.spacenerd.core.models.Launch
import com.adammcneilly.spacenerd.data.launch.api.LaunchListRequest

interface RemoteLaunchService {
    suspend fun getLaunches(
        request: LaunchListRequest,
    ): Result<List<Launch>>

    suspend fun getLaunch(
        id: String,
    ): Result<Launch>
}
