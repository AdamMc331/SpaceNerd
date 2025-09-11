package com.adammcneilly.spacenerd.data.expeditions.impl.local.room

import com.adammcneilly.spacenerd.core.models.Expedition
import com.adammcneilly.spacenerd.data.expeditions.api.ExpeditionListRequest
import com.adammcneilly.spacenerd.data.expeditions.api.local.LocalExpeditionService
import kotlinx.coroutines.flow.Flow

class RoomExpeditionService : LocalExpeditionService {
    override suspend fun saveExpeditions(
        expeditions: List<Expedition>,
    ) {
        TODO("Not yet implemented")
    }

    override fun getExpeditions(
        request: ExpeditionListRequest,
    ): Flow<List<Expedition>> {
        TODO("Not yet implemented")
    }
}
