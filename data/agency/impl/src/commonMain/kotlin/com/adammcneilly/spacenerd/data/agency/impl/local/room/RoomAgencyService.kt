package com.adammcneilly.spacenerd.data.agency.impl.local.room

import com.adammcneilly.spacenerd.core.models.Agency
import com.adammcneilly.spacenerd.data.agency.api.local.LocalAgencyService
import com.adammcneilly.spacenerd.data.local.room.daos.RoomAgencyDao
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomAgencyDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * This is an implementation of [LocalAgencyService] that requests data from a Room [agencyDao].
 */
class RoomAgencyService(
    private val agencyDao: RoomAgencyDao,
) : LocalAgencyService {
    override suspend fun saveAgency(
        agency: Agency,
    ) {
        val agencyDto = RoomAgencyDTO(agency)

        agencyDao.upsertAgency(agencyDto)
    }

    override fun getAgency(
        id: String,
    ): Flow<Agency> {
        return agencyDao.getAgency(id).map(RoomAgencyDTO::toAgency)
    }
}
