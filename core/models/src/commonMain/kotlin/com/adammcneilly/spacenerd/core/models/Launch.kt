package com.adammcneilly.spacenerd.core.models

import kotlinx.datetime.Instant

data class Launch(
    val id: String,
    val name: String,
    val imageUrl: String,
    val launchTimeUtc: Instant,
    val status: LaunchStatus,
    val provider: LaunchServiceProvider?,
    val pad: LaunchPad?,
)
