package com.adammcneilly.spacenerd.shared.core.models

import kotlinx.datetime.Instant

data class Launch(
    val id: String,
    val name: String,
    val imageUrl: String,
    val launchTime: Instant,
    val status: LaunchStatus,
    val agency: Agency?,
    val pad: LaunchPad?,
)
