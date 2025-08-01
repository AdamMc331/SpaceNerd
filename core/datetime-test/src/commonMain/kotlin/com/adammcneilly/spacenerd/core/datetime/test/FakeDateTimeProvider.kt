package com.adammcneilly.spacenerd.core.datetime.test

import com.adammcneilly.spacenerd.core.datetime.DateTimeProvider
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
class FakeDateTimeProvider : DateTimeProvider {
    lateinit var time: Instant

    override fun now(): Instant {
        return time
    }
}
