package com.adammcneilly.spacenerd.data.cache.test

import com.adammcneilly.spacenerd.core.datetime.DateTimeProvider
import com.adammcneilly.spacenerd.core.datetime.test.FakeDateTimeProvider
import com.adammcneilly.spacenerd.data.cache.CacheTimestampRepository
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
class FakeCacheTimestampRepository : CacheTimestampRepository {
    override val dateTimeProvider: DateTimeProvider = FakeDateTimeProvider()

    private val timestampsByKey: MutableMap<String, Instant> = mutableMapOf()

    override suspend fun getCacheTimestamp(
        key: String,
    ): Instant? {
        return timestampsByKey[key]
    }

    override suspend fun setCacheTimestamp(
        key: String,
    ) {
        timestampsByKey[key] = dateTimeProvider.now()
    }
}
