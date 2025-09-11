package com.adammcneilly.spacenerd.core.models

/**
 * Defines information about an [astronaut] that participated in
 * a launch or expedition with a specific [role].
 */
data class CrewMember(
    val id: String,
    val role: AstronautRole,
    val astronaut: Astronaut,
)
