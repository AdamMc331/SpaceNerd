package com.adammcneilly.spacenerd.data.models

import kotlinx.datetime.Instant

data class LaunchListRequest(
    val slug: String? = null,
    val before: Instant? = null,
    val after: Instant? = null,
)
