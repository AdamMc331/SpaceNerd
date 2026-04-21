package com.adammcneilly.spacenerd.data.astronauts.api

import com.adammcneilly.spacenerd.core.models.Astronaut
import com.adammcneilly.spacenerd.core.models.SyncStatus
import kotlinx.coroutines.flow.Flow

interface AstronautRepository {
    val syncStatus: Flow<SyncStatus>

    fun getAstronaut(
        astronautId: String,
    ): Flow<Astronaut>

    fun getAstronauts(
        request: AstronautListRequest,
    ): Flow<List<Astronaut>>
}
