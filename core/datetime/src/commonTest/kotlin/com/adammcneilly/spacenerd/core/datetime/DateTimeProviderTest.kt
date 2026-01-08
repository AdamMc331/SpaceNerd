package com.adammcneilly.spacenerd.core.datetime

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds
import kotlin.time.Instant

class DateTimeProviderTest {
    private class TestDateTimeProvider(
        private val now: Instant,
    ) : DateTimeProvider {
        override fun now(): Instant {
            return this.now
        }
    }

    @Test
    fun `relativeTimestamp returns 'now' for recent timestamps`() {
        val now = Instant.parse("2024-01-01T12:00:00Z")
        val timestamp = now.minus(30.seconds)
        val dateTimeProvider = TestDateTimeProvider(now)

        val result = dateTimeProvider.relativeTimestamp(timestamp)

        assertEquals("Just Now", result)
    }

    @Test
    fun `relativeTimestamp returns minutes ago`() {
        val now = Instant.parse("2024-01-01T12:00:00Z")
        val timestamp = now.minus(30.minutes)
        val dateTimeProvider = TestDateTimeProvider(now)

        val result = dateTimeProvider.relativeTimestamp(timestamp)

        assertEquals("30 minutes ago", result)
    }

    @Test
    fun `relativeTimestamp returns singular minute ago`() {
        val now = Instant.parse("2024-01-01T12:00:00Z")
        val timestamp = now.minus(1.minutes)
        val dateTimeProvider = TestDateTimeProvider(now)

        val result = dateTimeProvider.relativeTimestamp(timestamp)

        assertEquals("1 minute ago", result)
    }

    @Test
    fun `relativeTimestamp returns hours ago`() {
        val now = Instant.parse("2024-01-01T12:00:00Z")
        val timestamp = now.minus(2.hours)
        val dateTimeProvider = TestDateTimeProvider(now)

        val result = dateTimeProvider.relativeTimestamp(timestamp)

        assertEquals("2 hours ago", result)
    }

    @Test
    fun `relativeTimestamp returns singular hour ago`() {
        val now = Instant.parse("2024-01-01T12:00:00Z")
        val timestamp = now.minus(1.hours)
        val dateTimeProvider = TestDateTimeProvider(now)

        val result = dateTimeProvider.relativeTimestamp(timestamp)

        assertEquals("1 hour ago", result)
    }

    @Test
    fun `relativeTimestamp returns days ago`() {
        val now = Instant.parse("2024-01-01T12:00:00Z")
        val timestamp = now.minus(3.days)
        val dateTimeProvider = TestDateTimeProvider(now)

        val result = dateTimeProvider.relativeTimestamp(timestamp)

        assertEquals("3 days ago", result)
    }

    @Test
    fun `relativeTimestamp returns singular day ago`() {
        val now = Instant.parse("2024-01-01T12:00:00Z")
        val timestamp = now.minus(1.days)
        val dateTimeProvider = TestDateTimeProvider(now)

        val result = dateTimeProvider.relativeTimestamp(timestamp)

        assertEquals("1 day ago", result)
    }

    @Test
    fun `relativeTimestamp returns weeks ago`() {
        val now = Instant.parse("2024-01-01T12:00:00Z")
        val timestamp = now.minus(20.days)
        val dateTimeProvider = TestDateTimeProvider(now)

        val result = dateTimeProvider.relativeTimestamp(timestamp)

        assertEquals("2 weeks ago", result)
    }

    @Test
    fun `relativeTimestamp returns singular week ago`() {
        val now = Instant.parse("2024-01-01T12:00:00Z")
        val timestamp = now.minus(7.days)
        val dateTimeProvider = TestDateTimeProvider(now)

        val result = dateTimeProvider.relativeTimestamp(timestamp)

        assertEquals("1 week ago", result)
    }

    @Test
    fun `relativeTimestamp returns months ago`() {
        val now = Instant.parse("2024-01-01T12:00:00Z")
        val timestamp = now.minus(90.days)
        val dateTimeProvider = TestDateTimeProvider(now)

        val result = dateTimeProvider.relativeTimestamp(timestamp)

        assertEquals("3 months ago", result)
    }

    @Test
    fun `relativeTimestamp returns singular month ago`() {
        val now = Instant.parse("2024-01-01T12:00:00Z")
        val timestamp = now.minus(30.days)
        val dateTimeProvider = TestDateTimeProvider(now)

        val result = dateTimeProvider.relativeTimestamp(timestamp)

        assertEquals("1 month ago", result)
    }

    @Test
    fun `relativeTimestamp returns formatted date for old timestamps`() {
        val now = Instant.parse("2024-01-01T12:00:00Z")
        val timestamp = Instant.parse("2022-05-15T10:00:00Z")
        val dateTimeProvider = TestDateTimeProvider(now)

        val result = dateTimeProvider.relativeTimestamp(timestamp)

        assertEquals("May 15, 2022", result)
    }
}
