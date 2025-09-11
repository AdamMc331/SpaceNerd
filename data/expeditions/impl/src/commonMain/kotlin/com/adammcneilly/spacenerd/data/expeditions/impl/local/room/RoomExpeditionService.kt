package com.adammcneilly.spacenerd.data.expeditions.impl.local.room

import com.adammcneilly.spacenerd.core.datetime.DateTimeProvider
import com.adammcneilly.spacenerd.core.models.Expedition
import com.adammcneilly.spacenerd.data.expeditions.api.ExpeditionListRequest
import com.adammcneilly.spacenerd.data.expeditions.api.local.LocalExpeditionService
import com.adammcneilly.spacenerd.data.local.room.daos.RoomExpeditionDao
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomExpeditionWithCrewDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
class RoomExpeditionService(
    private val expeditionDao: RoomExpeditionDao,
    private val dateTimeProvider: DateTimeProvider,
) : LocalExpeditionService {
    override suspend fun saveExpeditions(
        expeditions: List<Expedition>,
    ) {
        expeditionDao.upsertDomainExpeditions(expeditions)
    }

    override fun getExpeditions(
        request: ExpeditionListRequest,
    ): Flow<List<Expedition>> {
        val roomFlow = if (request.isActive) {
            expeditionDao.getActiveExpeditions(
                spaceStationId = request.spaceStationId,
                now = dateTimeProvider.now().toString(),
            )
        } else {
            expeditionDao.getExpeditions(
                spaceStationId = request.spaceStationId,
            )
        }

        return roomFlow.map { roomDtos ->
            roomDtos.map(RoomExpeditionWithCrewDTO::toExpedition)
        }
    }
}
