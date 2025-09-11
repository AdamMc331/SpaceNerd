package com.adammcneilly.spacenerd.data.expeditions.api

import kotlin.time.ExperimentalTime

/**
 * Defines fields used to filter a list of expeditions from a data service.
 */
@OptIn(ExperimentalTime::class)
data class ExpeditionListRequest(
    val spaceStationId: String? = null,
    val isActive: Boolean = false,
)
