package com.adammcneilly.spacenerd.core.datetime

import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

/**
 * A [DateTimeProvider] that uses the system clock to provide the current time.
 */
@OptIn(ExperimentalTime::class)
class SystemDateTimeProvider : DateTimeProvider {
    override fun now(): Instant {
        return Clock.System.now()
    }
}
