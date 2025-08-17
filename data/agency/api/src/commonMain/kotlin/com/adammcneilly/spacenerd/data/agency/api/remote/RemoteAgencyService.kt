package com.adammcneilly.spacenerd.data.agency.api.remote

import com.adammcneilly.spacenerd.core.models.Agency

/**
 * Defines any requests to a remote data source for agency information.
 *
 * All functions inside this interface should be suspending, and return a singular [Result]
 * entity once the network request has completed.
 */
interface RemoteAgencyService {
    suspend fun getAgency(
        id: String,
    ): Result<Agency>
}
