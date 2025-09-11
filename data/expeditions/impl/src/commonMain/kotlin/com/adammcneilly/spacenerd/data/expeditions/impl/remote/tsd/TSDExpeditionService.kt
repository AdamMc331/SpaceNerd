package com.adammcneilly.spacenerd.data.expeditions.impl.remote.tsd

import com.adammcneilly.spacenerd.core.models.Expedition
import com.adammcneilly.spacenerd.data.expeditions.api.ExpeditionListRequest
import com.adammcneilly.spacenerd.data.expeditions.api.remote.RemoteExpeditionService

class TSDExpeditionService : RemoteExpeditionService {
    override suspend fun getExpeditions(
        request: ExpeditionListRequest,
    ): Result<List<Expedition>> {
        TODO("Not yet implemented")
    }
}
