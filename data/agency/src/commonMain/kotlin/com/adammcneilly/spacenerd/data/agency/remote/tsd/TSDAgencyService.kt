package com.adammcneilly.spacenerd.data.agency.remote.tsd

import com.adammcneilly.spacenerd.core.models.Agency
import com.adammcneilly.spacenerd.data.agency.remote.RemoteAgencyService
import com.adammcneilly.spacenerd.data.remote.ktor.BaseKtorClient
import com.adammcneilly.spacenerd.data.remote.tsd.dtos.TSDAgencyDTO

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
