package com.adammcneilly.spacenerd.data.stations.api

import com.adammcneilly.spacenerd.core.models.SpaceStationStatus

data class SpaceStationListRequest(
    val status: SpaceStationStatus? = null,
)
