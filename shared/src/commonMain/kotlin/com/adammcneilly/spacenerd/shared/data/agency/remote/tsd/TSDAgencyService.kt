package com.adammcneilly.spacenerd.shared.data.agency.remote.tsd

import com.adammcneilly.spacenerd.shared.core.models.Agency
import com.adammcneilly.spacenerd.shared.data.agency.remote.RemoteAgencyService
import com.adammcneilly.spacenerd.shared.data.launch.remote.tsd.dto.TSDAgencyDTO
import com.adammcneilly.spacenerd.shared.data.remote.ktor.BaseKtorClient

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
