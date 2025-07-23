package com.adammcneilly.spacenerd.data.stations.api

import com.adammcneilly.spacenerd.core.models.SpaceStation

data class SpaceStationListRequest(
    val status: SpaceStation.Status? = null,
)
