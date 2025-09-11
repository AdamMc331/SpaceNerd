package com.adammcneilly.spacenerd.data.expeditions.api.local

import com.adammcneilly.spacenerd.core.models.Expedition
import com.adammcneilly.spacenerd.data.expeditions.api.ExpeditionListRequest
import kotlinx.coroutines.flow.Flow

/**
 * Defines the data requests for fetching [Expedition] entities from a local data service.
 */
interface LocalExpeditionService {
    suspend fun saveExpeditions(
        expeditions: List<Expedition>,
    )

    fun getExpeditions(
        request: ExpeditionListRequest,
    ): Flow<List<Expedition>>
}
