package com.adammcneilly.spacenerd.data.astronauts.api.remote

import com.adammcneilly.spacenerd.core.models.Astronaut
import com.adammcneilly.spacenerd.data.astronauts.api.AstronautListRequest

interface RemoteAstronautService {
    suspend fun getAstronauts(
        request: AstronautListRequest,
    ): Result<List<Astronaut>>
}
