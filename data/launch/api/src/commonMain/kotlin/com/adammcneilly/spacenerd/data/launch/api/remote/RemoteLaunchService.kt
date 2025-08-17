package com.adammcneilly.spacenerd.data.launch.api.remote

import com.adammcneilly.spacenerd.core.models.Launch
import com.adammcneilly.spacenerd.data.launch.api.LaunchListRequest

/**
 * Defines any requests to a remote data source for launch information.
 *
 * All functions inside this interface should be suspending, and return a singular [Result]
 * entity once the network request has completed.
 */
interface RemoteLaunchService {
    suspend fun getLaunches(
        request: LaunchListRequest,
    ): Result<List<Launch>>

    suspend fun getLaunch(
        id: String,
    ): Result<Launch>
}
