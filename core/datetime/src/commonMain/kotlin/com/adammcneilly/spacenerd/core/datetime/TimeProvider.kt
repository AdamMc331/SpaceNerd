package com.adammcneilly.spacenerd.core.datetime

import kotlinx.datetime.Instant

interface TimeProvider {
    fun now(): Instant
}
