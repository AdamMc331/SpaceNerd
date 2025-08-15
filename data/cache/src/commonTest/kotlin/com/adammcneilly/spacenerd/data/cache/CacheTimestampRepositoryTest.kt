package com.adammcneilly.spacenerd.data.cache

import com.adammcneilly.spacenerd.core.datetime.DateTimeProvider
import com.varabyte.truthish.assertThat
import dev.mokkery.answering.returns
import dev.mokkery.everySuspend
import dev.mokkery.mock
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
private class FakeCacheTimestampRepository : CacheTimestampRepository {
    private val timestamps: MutableMap<String, Instant> = mutableMapOf()

    override val dateTimeProvider: DateTimeProvider = mock()

    override suspend fun getCacheTimestamp(
        key: String,
    ): Instant? {
        return timestamps[key]
    }

    override suspend fun setCacheTimestamp(
        key: String,
    ) {
        timestamps[key] = dateTimeProvider.now()
    }

    fun setNow(
        now: Instant,
    ) {
        everySuspend {
            dateTimeProvider.now()
        } returns now
    }
}

@OptIn(ExperimentalTime::class)
class CacheTimestampRepositoryTest {
    private val repository = FakeCacheTimestampRepository()

    @Test
    fun `should fetch if timestamp never set`() =
        runTest {
            val now = Instant.parse("2023-01-01T00:00:00Z")
            repository.setNow(now)

            val shouldSync = repository.shouldSyncWithServer("test", 1.hours)
            assertThat(shouldSync).isTrue()
        }

    @Test
    fun `should fetch if timestamp beyond duration`() =
        runTest {
            val now = Instant.parse("2023-01-01T00:00:00Z")
            val lastCache = now.minus(2.hours)
            val syncDuration = 1.hours
            val key = "key"
            repository.setNow(lastCache)
            repository.setCacheTimestamp(key)
            repository.setNow(now)

            val shouldSync = repository.shouldSyncWithServer(key, syncDuration)
            assertThat(shouldSync).isTrue()
        }

    @Test
    fun `should not fetch if timestamp within duration`() =
        runTest {
            val now = Instant.parse("2023-01-01T00:00:00Z")
            val lastCache = now.minus(30.minutes)
            val syncDuration = 1.hours
            val key = "key"
            repository.setNow(lastCache)
            repository.setCacheTimestamp(key)
            repository.setNow(now)

            val shouldSync = repository.shouldSyncWithServer(key, syncDuration)
            assertThat(shouldSync).isFalse()
        }
}
