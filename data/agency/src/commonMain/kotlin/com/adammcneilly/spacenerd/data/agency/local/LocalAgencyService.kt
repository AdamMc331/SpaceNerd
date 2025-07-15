package com.adammcneilly.spacenerd.data.agency.local

import com.adammcneilly.spacenerd.core.models.Agency
import kotlinx.coroutines.flow.Flow

interface LocalAgencyService {
    suspend fun saveAgency(
        agency: Agency,
    )

    fun getAgency(
        id: String,
    ): Flow<Agency>
}
