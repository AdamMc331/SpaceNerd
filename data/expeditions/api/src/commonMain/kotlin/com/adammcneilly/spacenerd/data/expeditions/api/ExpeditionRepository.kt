package com.adammcneilly.spacenerd.data.expeditions.api

import com.adammcneilly.spacenerd.core.models.Expedition
import kotlinx.coroutines.flow.Flow

/**
 * Defines any data requests to retrieve expedition information from one or many data sources.
 *
 * Each function in this interface should return a [Flow], that emits any time the corresponding
 * data changes.
 */
interface ExpeditionRepository {
    fun getExpeditions(
        request: ExpeditionListRequest,
    ): Flow<List<Expedition>>
}
