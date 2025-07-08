package com.adammcneilly.spacenerd.shared.datetime

import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
class SystemDateTimeProvider : DateTimeProvider {
    override fun now(): Instant {
        return Clock.System.now()
    }
}
