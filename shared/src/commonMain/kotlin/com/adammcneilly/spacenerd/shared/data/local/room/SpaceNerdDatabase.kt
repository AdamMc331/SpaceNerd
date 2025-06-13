package com.adammcneilly.spacenerd.shared.data.local.room

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.adammcneilly.spacenerd.shared.data.article.local.room.RoomArticleDTO
import com.adammcneilly.spacenerd.shared.data.article.local.room.RoomArticleDao
import com.adammcneilly.spacenerd.shared.data.cache.local.room.RoomCacheTimestampDTO
import com.adammcneilly.spacenerd.shared.data.cache.local.room.RoomCacheTimestampDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

@Database(
    version = 1,
    entities = [
        RoomArticleDTO::class,
        RoomCacheTimestampDTO::class,
    ],
)
@ConstructedBy(SpaceNerdDatabaseConstructor::class)
abstract class SpaceNerdDatabase : RoomDatabase() {
    abstract fun articleDao(): RoomArticleDao

    abstract fun cacheTimestampDao(): RoomCacheTimestampDao
}

/**
 * The Room compiler generates the `actual` implementations.
 */
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object SpaceNerdDatabaseConstructor : RoomDatabaseConstructor<SpaceNerdDatabase> {
    override fun initialize(): SpaceNerdDatabase
}

/**
 * Database name constant
 */
internal const val DATABASE_NAME = "spacenerd.db"

/**
 * Create the database builder - expect/actual implementation per platform
 */
expect fun getDatabaseBuilder(): RoomDatabase.Builder<SpaceNerdDatabase>

/**
 * Get database instance - singleton pattern
 */
fun getDatabase(): SpaceNerdDatabase {
    return getDatabaseBuilder()
        .setQueryCoroutineContext(Dispatchers.IO)
        .setDriver(BundledSQLiteDriver()) // Essential for KMP
        // Replace with migrations when stable
        .fallbackToDestructiveMigrationOnDowngrade(dropAllTables = true)
        .build()
}
