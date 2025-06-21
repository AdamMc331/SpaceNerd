package com.adammcneilly.spacenerd.shared.data.agency.local

import com.adammcneilly.spacenerd.shared.core.models.Agency
import kotlinx.coroutines.flow.Flow

interface LocalAgencyService {
    suspend fun saveAgency(
        agency: Agency,
        overwrite: Boolean,
    )

    fun getAgency(
        id: String,
    ): Flow<Agency>
}
