package com.adammcneilly.spacenerd.core.datetime

import kotlin.time.Instant

class DebugTimeProvider(
    private val now: Instant = Instant.parse("2023-01-01T00:00:00Z"),
) : DateTimeProvider {
    override fun now(): Instant {
        return now
    }
}
