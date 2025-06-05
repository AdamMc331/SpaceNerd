package com.adammcneilly.spacenerd.data.cache.api

import kotlinx.datetime.Instant

interface CacheTimestampRepository {
    suspend fun saveLastFetchTime(
        key: String,
        fetchTime: Instant,
    )

    suspend fun getLastFetchTime(
        key: String,
    ): Instant?
}
