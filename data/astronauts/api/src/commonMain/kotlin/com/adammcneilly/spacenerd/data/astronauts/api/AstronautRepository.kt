package com.adammcneilly.spacenerd.data.astronauts.api

import com.adammcneilly.spacenerd.core.models.Astronaut
import kotlinx.coroutines.flow.Flow

interface AstronautRepository {
    fun getAstronaut(
        astronautId: String,
    ): Flow<Astronaut>
}
