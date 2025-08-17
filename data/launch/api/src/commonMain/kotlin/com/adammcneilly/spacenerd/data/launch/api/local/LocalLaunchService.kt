package com.adammcneilly.spacenerd.data.launch.api.local

import com.adammcneilly.spacenerd.core.models.Launch
import com.adammcneilly.spacenerd.data.launch.api.LaunchListRequest
import kotlinx.coroutines.flow.Flow

/**
 * This is a data source that requests launch information from a local data source.
 *
 * All functions should return a [Flow] that emits any time the local data source changes.
 * Any functions to save data should be suspending and operate on a background thread.
 */
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
