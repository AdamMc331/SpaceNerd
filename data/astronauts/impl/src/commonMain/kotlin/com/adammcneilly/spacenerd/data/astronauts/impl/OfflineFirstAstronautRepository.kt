package com.adammcneilly.spacenerd.data.astronauts.impl

import com.adammcneilly.spacenerd.core.models.Astronaut
import com.adammcneilly.spacenerd.data.astronauts.api.AstronautRepository
import com.adammcneilly.spacenerd.data.astronauts.api.local.LocalAstronautService
import kotlinx.coroutines.flow.Flow

class OfflineFirstAstronautRepository(
    private val localAstronautService: LocalAstronautService,
) : AstronautRepository {
    override fun getAstronaut(
        astronautId: String,
    ): Flow<Astronaut> {
        return localAstronautService.getAstronaut(astronautId)
    }
}
