package com.adammcneilly.spacenerd.data.launch.api

import com.adammcneilly.spacenerd.core.models.Launch
import kotlinx.coroutines.flow.Flow

/**
 * Defines any data requests to retrieve launch information from one or many data sources.
 *
 * Each function in this interface should return a [Flow], that emits any time the corresponding
 * data changes.
 */
interface LaunchRepository {
    fun getLaunches(
        request: LaunchListRequest,
    ): Flow<List<Launch>>

    fun getLaunch(
        id: String,
    ): Flow<Launch>
}
