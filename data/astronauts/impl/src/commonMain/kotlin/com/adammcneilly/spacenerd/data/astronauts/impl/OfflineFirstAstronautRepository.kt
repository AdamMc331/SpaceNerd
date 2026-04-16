package com.adammcneilly.spacenerd.data.astronauts.impl

import com.adammcneilly.spacenerd.core.models.Astronaut
import com.adammcneilly.spacenerd.data.astronauts.api.AstronautListRequest
import com.adammcneilly.spacenerd.data.astronauts.api.AstronautRepository
import com.adammcneilly.spacenerd.data.astronauts.api.local.LocalAstronautService
import com.adammcneilly.spacenerd.data.astronauts.api.remote.RemoteAstronautService
import kotlinx.coroutines.flow.Flow

class OfflineFirstAstronautRepository(
    private val localAstronautService: LocalAstronautService,
    private val remoteAstronautService: RemoteAstronautService,
) : AstronautRepository {
    override fun getAstronaut(
        astronautId: String,
    ): Flow<Astronaut> {
        return localAstronautService.getAstronaut(astronautId)
    }

    override fun getAstronauts(
        request: AstronautListRequest,
    ): Flow<List<Astronaut>> {
        // Need to sync with remote server
        return localAstronautService.getAstronauts(request)
    }
}
