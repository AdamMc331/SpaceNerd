package com.adammcneilly.spacenerd.shared.data.launch

import com.adammcneilly.spacenerd.shared.core.models.Launch
import kotlinx.coroutines.flow.Flow

interface LaunchRepository {
    fun getLaunches(
        request: LaunchListRequest,
    ): Flow<List<Launch>>

    fun getLaunch(
        id: String,
    ): Flow<Launch>
}
