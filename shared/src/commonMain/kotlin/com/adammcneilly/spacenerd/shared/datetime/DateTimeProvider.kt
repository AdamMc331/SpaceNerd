package com.adammcneilly.spacenerd.shared.datetime

import kotlinx.datetime.Instant

interface DateTimeProvider {
    fun now(): Instant
}
