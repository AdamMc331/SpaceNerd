package com.adammcneilly.spacenerd.core.models

import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
data class Expedition(
    val id: String,
    val start: Instant,
    val end: Instant?,
    val name: String,
    val spaceStation: SpaceStation,
    val crew: List<CrewMember>,
)
