package com.adammcneilly.spacenerd.shared.data.agency.local.room

import com.adammcneilly.spacenerd.shared.core.models.Agency
import com.adammcneilly.spacenerd.shared.data.agency.local.LocalAgencyService
import com.adammcneilly.spacenerd.shared.data.agency.local.room.dto.RoomAgencyDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RoomAgencyService(
    private val agencyDao: RoomAgencyDao,
) : LocalAgencyService {
    override suspend fun saveAgency(
        agency: Agency,
    ) {
        val agencyDto = RoomAgencyDTO(agency)

        agencyDao.insertOrReplaceAgency(agencyDto)
    }

    override fun getAgency(
        id: String,
    ): Flow<Agency> {
        return agencyDao.getAgency(id).map(RoomAgencyDTO::toAgency)
    }
}
