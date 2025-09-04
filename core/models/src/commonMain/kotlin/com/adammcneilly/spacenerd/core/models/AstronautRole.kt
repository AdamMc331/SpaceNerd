package com.adammcneilly.spacenerd.core.models

/**
 * Defines an [Astronaut]'s role within a certain launch, such as commander, engineer, etc.
 */
data class AstronautRole(
    val id: String,
    val name: String,
    val priority: Int,
)
