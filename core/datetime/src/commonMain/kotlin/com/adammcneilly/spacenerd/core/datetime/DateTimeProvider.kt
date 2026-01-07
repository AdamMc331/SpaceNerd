package com.adammcneilly.spacenerd.core.datetime

import kotlinx.datetime.format
import kotlinx.datetime.format.DateTimeComponents
import kotlinx.datetime.format.MonthNames
import kotlinx.datetime.format.Padding
import kotlinx.datetime.format.char
import kotlin.time.Duration
import kotlin.time.Instant

private const val DAYS_PER_WEEK = 7
private const val DAYS_PER_MONTH = 30
private const val DAYS_PER_YEAR = 365

private val fullDateFormat = DateTimeComponents.Format {
    monthName(MonthNames.ENGLISH_FULL)
    char(' ')
    day()
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
            duration.inWholeDays < DAYS_PER_WEEK -> formatDaysAgo(duration)
            duration.inWholeDays < DAYS_PER_MONTH -> formatWeeksAgo(duration)
            duration.inWholeDays < DAYS_PER_YEAR -> formatMonthsAgo(duration)
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
