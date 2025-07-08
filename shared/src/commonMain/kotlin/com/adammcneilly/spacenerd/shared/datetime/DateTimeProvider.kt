package com.adammcneilly.spacenerd.shared.datetime

import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
interface DateTimeProvider {
    fun now(): Instant
}
