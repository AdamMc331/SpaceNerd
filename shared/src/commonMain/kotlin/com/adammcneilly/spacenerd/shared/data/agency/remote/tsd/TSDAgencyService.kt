package com.adammcneilly.spacenerd.shared.data.agency.remote.tsd

import com.adammcneilly.spacenerd.core.models.Agency
import com.adammcneilly.spacenerd.data.remote.ktor.BaseKtorClient
import com.adammcneilly.spacenerd.data.remote.tsd.dtos.TSDAgencyDTO
import com.adammcneilly.spacenerd.shared.data.agency.remote.RemoteAgencyService

class TSDAgencyService(
    private val client: BaseKtorClient,
) : RemoteAgencyService {
    override suspend fun getAgency(
        id: String,
    ): Result<Agency> {
        return client.getResponse<TSDAgencyDTO>(
            endpoint = "agencies/$id",
        ).map(TSDAgencyDTO::toAgency)
    }
}
