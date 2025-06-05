package com.adammcneilly.spacenerd.data.launch.api

import kotlinx.datetime.Instant

sealed class LaunchListRequest {
    data object Upcoming : LaunchListRequest()

    data class Custom(
        val before: Instant? = null,
        val after: Instant? = null,
    ) : LaunchListRequest()
}
