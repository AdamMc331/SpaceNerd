package com.adammcneilly.spacenerd.data.astronauts.impl.local.room

import com.adammcneilly.spacenerd.core.models.Astronaut
import com.adammcneilly.spacenerd.data.astronauts.api.AstronautListRequest
import com.adammcneilly.spacenerd.data.astronauts.api.local.LocalAstronautService
import com.adammcneilly.spacenerd.data.local.room.daos.RoomAstronautDao
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomAstronautDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomAstronautDetailDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RoomAstronautService(
    private val astronautDao: RoomAstronautDao,
) : LocalAstronautService {
    override fun getAstronaut(
        astronautId: String,
    ): Flow<Astronaut> {
        return astronautDao.getAstronaut(astronautId).map(RoomAstronautDetailDTO::toAstronaut)
    }

    override fun getAstronauts(
        request: AstronautListRequest,
    ): Flow<List<Astronaut>> {
        return astronautDao.getAstronauts(
//            inSpace = request.inSpace,
        ).map { astronautList ->
            astronautList.map(RoomAstronautDetailDTO::toAstronaut)
        }
    }

    override suspend fun saveAstronauts(
        astronauts: List<Astronaut>,
    ) {
        for (astronaut in astronauts) {
            astronautDao.upsertDomainAstronaut(astronaut)
        }
    }
}
