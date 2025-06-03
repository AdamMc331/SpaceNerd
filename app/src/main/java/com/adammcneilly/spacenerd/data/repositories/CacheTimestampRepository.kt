package com.adammcneilly.spacenerd.data.repositories

import kotlinx.datetime.Instant

interface CacheTimestampRepository {
    suspend fun getCacheTimestamp(
        key: String,
    ): Instant?

    suspend fun setCacheTimestamp(
        key: String,
        timestamp: Instant,
    )

    companion object {
        const val KEY_ARTICLES = "articles"
    }
}
