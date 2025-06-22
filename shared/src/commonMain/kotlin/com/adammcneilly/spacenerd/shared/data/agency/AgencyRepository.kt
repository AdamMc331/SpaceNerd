package com.adammcneilly.spacenerd.shared.data.agency

import com.adammcneilly.spacenerd.shared.core.models.Agency
import kotlinx.coroutines.flow.Flow

interface AgencyRepository {
    fun getAgency(
        id: String,
    ): Flow<Agency>
}
