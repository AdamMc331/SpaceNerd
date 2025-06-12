package com.adammcneilly.spacenerd.data.repositories

import com.adammcneilly.spacenerd.data.models.LaunchListRequest
import com.adammcneilly.spacenerd.shared.core.models.Launch
import kotlinx.coroutines.flow.Flow

interface LaunchRepository {
    fun getLaunches(
        request: LaunchListRequest,
    ): Flow<List<Launch>>

    fun getLaunch(
        launchId: String,
    ): Flow<Launch>
}
