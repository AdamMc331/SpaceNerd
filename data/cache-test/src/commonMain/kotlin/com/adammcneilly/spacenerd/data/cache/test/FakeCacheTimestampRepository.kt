package com.adammcneilly.spacenerd.data.cache.test

import com.adammcneilly.spacenerd.core.datetime.DateTimeProvider
import com.adammcneilly.spacenerd.data.cache.CacheTimestampRepository
import com.varabyte.truthish.assertThat
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
class FakeCacheTimestampRepository(
    override val dateTimeProvider: DateTimeProvider,
) : CacheTimestampRepository {
    private val timestampsByKey: MutableMap<String, Instant?> = mutableMapOf()
    private val savedTimestamps: MutableMap<String, Instant> = mutableMapOf()
    private val timestampsSet: MutableList<String> = mutableListOf()

    override suspend fun getCacheTimestamp(
        key: String,
    ): Instant? {
        return timestampsByKey[key]
    }

    override suspend fun setCacheTimestamp(
        key: String,
    ) {
        timestampsSet.add(key)
    }

    fun setTimestampForKey(
        key: String,
        timestamp: Instant?,
    ) {
        timestampsByKey[key] = timestamp
    }

    fun verifyTimestampSet(
        key: String,
    ) {
        assertThat(timestampsSet).contains(key)
    }

    fun verifyNoTimestampSet() {
        assertThat(timestampsSet).isEmpty()
    }
}
