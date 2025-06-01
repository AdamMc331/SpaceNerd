package com.adammcneilly.spacenerd.data.repositories

import com.adammcneilly.spacenerd.core.models.Launch
import com.adammcneilly.spacenerd.data.models.LaunchListRequest
import kotlinx.coroutines.flow.Flow

interface LaunchRepository {
    fun getLaunches(
        request: LaunchListRequest,
    ): Flow<List<Launch>>
}
