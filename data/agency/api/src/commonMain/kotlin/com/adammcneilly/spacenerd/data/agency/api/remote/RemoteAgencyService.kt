package com.adammcneilly.spacenerd.data.agency.api.remote

import com.adammcneilly.spacenerd.core.models.Agency

interface RemoteAgencyService {
    suspend fun getAgency(
        id: String,
    ): Result<Agency>
}
