package com.adammcneilly.spacenerd.core.models

data class SpaceStation(
    val id: String,
    val name: String,
    val status: SpaceStationStatus,
    val imageUrl: String,
)
