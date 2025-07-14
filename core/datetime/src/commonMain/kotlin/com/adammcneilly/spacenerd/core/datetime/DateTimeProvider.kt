package com.adammcneilly.spacenerd.core.datetime

import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
interface DateTimeProvider {
    fun now(): Instant
}
