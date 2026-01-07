package com.adammcneilly.spacenerd.core.datetime

import kotlinx.datetime.TimeZone
import kotlinx.datetime.format
import kotlinx.datetime.format.DateTimeComponents
import kotlinx.datetime.format.MonthNames
import kotlinx.datetime.format.Padding
import kotlinx.datetime.format.char
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Duration
import kotlin.time.Instant

private val fullDateFormat = DateTimeComponents.Format {
    monthName(MonthNames.ENGLISH_FULL)
    char(' ')
    dayOfMonth(Padding.NONE)
    char(',')
    char(' ')
    year()
}

/**
 * A provider for the current date and time.
 */
interface DateTimeProvider {
    /**
     * @return The current [Instant].
     */
    fun now(): Instant

    /**
     * Returns a relative timestamp between the given [timestamp] and [now].
     */
    fun relativeTimestamp(
        timestamp: Instant,
    ): String {
        val now = this.now()
        val duration = now.minus(timestamp)

        return when {
            duration.inWholeMinutes < 1 -> "Just Now"
            duration.inWholeHours < 1 -> formatMinutesAgo(duration)
            duration.inWholeDays < 1 -> formatHoursAgo(duration)
            duration.inWholeDays < 7 -> formatDaysAgo(duration)
            duration.inWholeDays < 30 -> formatWeeksAgo(duration)
            duration.inWholeDays < 365 -> formatMonthsAgo(duration)
            else -> formatDate(timestamp)
        }
    }

    private fun formatMinutesAgo(
        duration: Duration,
    ): String {
        val minutes = duration.inWholeMinutes
        return "$minutes minute${if (minutes > 1) "s" else ""} ago"
    }

    private fun formatHoursAgo(
        duration: Duration,
    ): String {
        val hours = duration.inWholeHours
        return "$hours hour${if (hours > 1) "s" else ""} ago"
    }

    private fun formatDaysAgo(
        duration: Duration,
    ): String {
        val days = duration.inWholeDays
        return "$days day${if (days > 1) "s" else ""} ago"
    }

    private fun formatWeeksAgo(
        duration: Duration,
    ): String {
        val weeks = duration.inWholeDays / 7
        return "$weeks week${if (weeks > 1) "s" else ""} ago"
    }

    private fun formatMonthsAgo(
        duration: Duration,
    ): String {
        val months = duration.inWholeDays / 30
        return "$months month${if (months > 1) "s" else ""} ago"
    }

    private fun formatDate(
        timestamp: Instant,
    ): String {
        return timestamp.format(fullDateFormat)
    }
}
