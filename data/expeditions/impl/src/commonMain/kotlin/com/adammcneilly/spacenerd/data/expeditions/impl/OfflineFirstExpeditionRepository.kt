package com.adammcneilly.spacenerd.data.expeditions.impl

import com.adammcneilly.spacenerd.core.models.Expedition
import com.adammcneilly.spacenerd.data.expeditions.api.ExpeditionListRequest
import com.adammcneilly.spacenerd.data.expeditions.api.ExpeditionRepository
import kotlinx.coroutines.flow.Flow

class OfflineFirstExpeditionRepository : ExpeditionRepository {
    override fun getExpeditions(
        request: ExpeditionListRequest,
    ): Flow<List<Expedition>> {
        TODO("Not yet implemented")
    }
}
