package com.adammcneilly.spacenerd.core.models

data class SpaceStation(
    val id: String,
    val name: String,
    val status: Status,
    val imageUrl: String,
) {
    enum class Status {
        Active,
        DeOrbited,
        Decommissioned,
    }
}
