package com.adammcneilly.spacenerd.data.launch.api

import kotlinx.datetime.Instant

data class LaunchListRequest(
    val before: Instant? = null,
    val after: Instant? = null,
)
