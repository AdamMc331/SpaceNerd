package com.adammcneilly.spacenerd.data.expeditions.impl.remote.tsd

import com.adammcneilly.spacenerd.core.datetime.DateTimeProvider
import com.adammcneilly.spacenerd.core.models.Expedition
import com.adammcneilly.spacenerd.data.expeditions.api.ExpeditionListRequest
import com.adammcneilly.spacenerd.data.expeditions.api.remote.RemoteExpeditionService
import com.adammcneilly.spacenerd.data.remote.ktor.BaseKtorClient
import com.adammcneilly.spacenerd.data.remote.tsd.dtos.TSDExpeditionListResponseDTO
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
class TSDExpeditionService(
    private val client: BaseKtorClient,
    private val dateTimeProvider: DateTimeProvider,
) : RemoteExpeditionService {
    /**
     * The TSD API does not let us filter for active expeditions. So if the [ExpeditionListRequest.isActive] field is true,
     * we will pass in the current date to filter for expeditions that started before today. Then, we will filter the API response
     * to only include expeditions with a null end date.
     */
    override suspend fun getExpeditions(
        request: ExpeditionListRequest,
    ): Result<List<Expedition>> {
        return client.getResponse<TSDExpeditionListResponseDTO>(
            endpoint = "expeditions",
            params = mapOf(
                "space_station" to request.spaceStationId,
                "start__lte" to dateTimeProvider.now().toString().takeIf { request.isActive },
                "ordering" to "-end",
            ),
        ).map { expeditionListResponseDTO ->
            expeditionListResponseDTO.results?.map { expeditionDTO ->
                expeditionDTO.toExpedition()
            }.orEmpty().filter { expedition ->
                if (request.isActive) {
                    expedition.end == null
                } else {
                    true
                }
            }
        }
    }
}
