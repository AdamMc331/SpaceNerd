package com.adammcneilly.spacenerd.data.launch.api

import com.adammcneilly.spacenerd.core.models.Launch
import kotlinx.coroutines.flow.Flow

interface LaunchRepository {
    fun getLaunches(
        request: LaunchListRequest,
    ): Flow<List<Launch>>
}
