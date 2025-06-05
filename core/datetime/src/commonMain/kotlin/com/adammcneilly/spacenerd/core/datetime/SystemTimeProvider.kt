package com.adammcneilly.spacenerd.core.datetime

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant

object SystemTimeProvider : TimeProvider {
    override fun now(): Instant {
        return Clock.System.now()
    }
}
