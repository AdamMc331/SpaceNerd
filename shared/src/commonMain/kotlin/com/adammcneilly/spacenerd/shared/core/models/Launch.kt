package com.adammcneilly.spacenerd.core.models

import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
data class Launch(
    val id: String,
    val name: String,
    val imageUrl: String,
    val launchTime: Instant,
    val status: LaunchStatus,
    val agency: Agency?,
    val pad: LaunchPad?,
    val mission: Mission?,
)
