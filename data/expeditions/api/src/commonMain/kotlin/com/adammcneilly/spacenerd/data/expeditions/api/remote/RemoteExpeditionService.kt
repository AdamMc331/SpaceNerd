package com.adammcneilly.spacenerd.data.expeditions.api.remote

import com.adammcneilly.spacenerd.core.models.Expedition
import com.adammcneilly.spacenerd.data.expeditions.api.ExpeditionListRequest

/**
 * Defines the data layer for requesting [Expedition] entities from a remote data service.
 */
interface RemoteExpeditionService {
    suspend fun getExpeditions(
        request: ExpeditionListRequest,
    ): Result<List<Expedition>>
}
