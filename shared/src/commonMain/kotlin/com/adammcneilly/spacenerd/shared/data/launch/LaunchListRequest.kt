package com.adammcneilly.spacenerd.shared.data.launch

import kotlinx.datetime.Instant

sealed interface LaunchListRequest {
    data object Upcoming : LaunchListRequest

    data class Custom(
        val before: Instant? = null,
        val after: Instant? = null,
    ) : LaunchListRequest
}
