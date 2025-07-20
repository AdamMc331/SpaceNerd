package com.adammcneilly.spacenerd.data.agency

import com.adammcneilly.spacenerd.core.models.Agency
import kotlinx.coroutines.flow.Flow

interface AgencyRepository {
    fun getAgency(
        id: String,
    ): Flow<Agency>
}
