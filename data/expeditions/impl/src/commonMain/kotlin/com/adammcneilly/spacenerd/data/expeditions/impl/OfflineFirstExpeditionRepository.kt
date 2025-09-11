package com.adammcneilly.spacenerd.data.expeditions.impl

import com.adammcneilly.spacenerd.core.models.Expedition
import com.adammcneilly.spacenerd.data.expeditions.api.ExpeditionListRequest
import com.adammcneilly.spacenerd.data.expeditions.api.ExpeditionRepository
import com.adammcneilly.spacenerd.data.expeditions.api.local.LocalExpeditionService
import com.adammcneilly.spacenerd.data.expeditions.api.remote.RemoteExpeditionService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onStart

class OfflineFirstExpeditionRepository(
    private val localExpeditionService: LocalExpeditionService,
    private val remoteExpeditionService: RemoteExpeditionService,
) : ExpeditionRepository {
    override fun getExpeditions(
        request: ExpeditionListRequest,
    ): Flow<List<Expedition>> {
        return localExpeditionService.getExpeditions(request)
            .onStart {
                val response = remoteExpeditionService.getExpeditions(request)

                val expeditions = response.getOrNull()
                if (expeditions != null) {
                    localExpeditionService.saveExpeditions(expeditions)
                }

                val error = response.exceptionOrNull()
                if (error != null) {
                    // Need to log this somewhere
                    println("Error fetching expeditions $request: $error")
                }
            }
    }
}
