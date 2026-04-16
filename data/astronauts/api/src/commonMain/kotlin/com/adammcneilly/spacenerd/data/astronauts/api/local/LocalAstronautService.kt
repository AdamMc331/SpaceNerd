package com.adammcneilly.spacenerd.data.astronauts.api.local

import com.adammcneilly.spacenerd.core.models.Astronaut
import com.adammcneilly.spacenerd.data.astronauts.api.AstronautListRequest
import kotlinx.coroutines.flow.Flow

interface LocalAstronautService {
    fun getAstronaut(
        astronautId: String,
    ): Flow<Astronaut>

    fun getAstronauts(
        request: AstronautListRequest,
    ): Flow<List<Astronaut>>
}
