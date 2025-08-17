package com.adammcneilly.spacenerd.data.stations.api

import com.adammcneilly.spacenerd.core.models.SpaceStationStatus

/**
 * This request defines all of the fields that we want to use to filter a list of space stations
 * from a data source. Null values imply we don't want to filter by that property.
 */
data class SpaceStationListRequest(
    val status: SpaceStationStatus? = null,
)
