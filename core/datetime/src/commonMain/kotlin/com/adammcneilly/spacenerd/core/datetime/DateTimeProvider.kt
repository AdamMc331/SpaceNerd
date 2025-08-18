package com.adammcneilly.spacenerd.core.datetime

import kotlin.time.ExperimentalTime
import kotlin.time.Instant

/**
 * A provider for the current date and time.
 */
@OptIn(ExperimentalTime::class)
interface DateTimeProvider {
    /**
     * @return The current [Instant].
     */
    fun now(): Instant
}
