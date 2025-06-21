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
        overwrite: Boolean,
    ) {
        val agencyDto = RoomAgencyDTO(agency)

        if (overwrite) {
            agencyDao.insertOrReplaceAgency(agencyDto)
        } else {
            agencyDao.insertOrIgnoreAgency(agencyDto)
        }
    }

    override fun getAgency(
        id: String,
    ): Flow<Agency> {
        return agencyDao.getAgency(id).map(RoomAgencyDTO::toAgency)
    }
}
