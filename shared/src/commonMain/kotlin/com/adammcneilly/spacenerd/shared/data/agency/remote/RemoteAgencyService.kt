package com.adammcneilly.spacenerd.shared.data.agency.remote

import com.adammcneilly.spacenerd.shared.core.models.Agency

interface RemoteAgencyService {
    suspend fun getAgency(
        id: String,
    ): Result<Agency>
}
