package com.adammcneilly.spacenerd.data.launch.api

import kotlin.time.ExperimentalTime
import kotlin.time.Instant

/**
 * This sealed interface defines the different type of requests for a list of launches.
 */
sealed interface LaunchListRequest {
    /**
     * Requests all upcoming launches. This will include a 24 hour buffer in the past, to get current
     * or very recent launches.
     */
    data object Upcoming : LaunchListRequest

    /**
     * This is a custom launch list request, that allows filtering by multiple variables together.
     */
    @OptIn(ExperimentalTime::class)
    data class Custom(
        val before: Instant? = null,
        val after: Instant? = null,
        val hasCrew: Boolean? = null,
    ) : LaunchListRequest
}
