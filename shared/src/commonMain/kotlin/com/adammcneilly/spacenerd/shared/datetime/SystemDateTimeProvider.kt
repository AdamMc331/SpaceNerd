package com.adammcneilly.spacenerd.shared.datetime

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant

class SystemDateTimeProvider : DateTimeProvider {
    override fun now(): Instant {
        return Clock.System.now()
    }
}
