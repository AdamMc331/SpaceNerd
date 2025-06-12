package com.adammcneilly.spacenerd.shared.data.cache

import kotlinx.datetime.Instant
import kotlin.time.Duration

interface CacheTimestampRepository {
    suspend fun getCacheTimestamp(
        key: String,
    ): Instant?

    suspend fun setCacheTimestamp(
        key: String,
        timestamp: Instant,
    )

    /**
     * Retrieves the most recent cache timestamp for the [key] and checks
     * if the time between that instant and [currentTime]
     * exceeds the [cacheDuration].
     *
     * @return True if the duration since last request exceeds [cacheDuration],
     * or if [getCacheTimestamp] for [key] is null.
     */
    suspend fun shouldSyncWithServer(
        key: String,
        currentTime: Instant,
        cacheDuration: Duration,
    ): Boolean {
        val lastFetchTimestamp = getCacheTimestamp(key)

        return if (lastFetchTimestamp == null) {
            true
        } else {
            (currentTime - cacheDuration) > lastFetchTimestamp
        }
    }

    companion object {
        const val KEY_ARTICLES = "articles"
    }
}
