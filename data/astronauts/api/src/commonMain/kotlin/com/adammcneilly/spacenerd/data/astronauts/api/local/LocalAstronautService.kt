package com.adammcneilly.spacenerd.data.astronauts.api.local

import com.adammcneilly.spacenerd.core.models.Astronaut
import kotlinx.coroutines.flow.Flow

interface LocalAstronautService {
    fun getAstronaut(
        astronautId: String,
    ): Flow<Astronaut>
}
