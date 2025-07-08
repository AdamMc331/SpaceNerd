package com.adammcneilly.spacenerd.shared.data.launch

import kotlin.time.ExperimentalTime
import kotlin.time.Instant

sealed interface LaunchListRequest {
    data object Upcoming : LaunchListRequest

    @OptIn(ExperimentalTime::class)
    data class Custom(
        val before: Instant? = null,
        val after: Instant? = null,
    ) : LaunchListRequest
}
