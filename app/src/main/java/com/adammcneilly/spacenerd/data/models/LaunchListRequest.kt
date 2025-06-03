package com.adammcneilly.spacenerd.data.models

import kotlinx.datetime.Instant

sealed class LaunchListRequest {
    data object Upcoming : LaunchListRequest()

    data class Custom(
        val slug: String? = null,
        val before: Instant? = null,
        val after: Instant? = null,
    ) : LaunchListRequest()
}
