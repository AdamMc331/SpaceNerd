package com.adammcneilly.spacenerd.core.models

/**
 * Defines information about an [astronaut] that participated in a launch
 * with a specific [role].
 */
data class LaunchCrewMember(
    val id: String,
    val role: AstronautRole,
    val astronaut: Astronaut,
)
