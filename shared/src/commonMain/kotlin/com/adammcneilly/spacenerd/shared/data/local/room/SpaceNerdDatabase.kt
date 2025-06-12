package com.adammcneilly.spacenerd.shared.data.local.room

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import com.adammcneilly.spacenerd.shared.data.article.local.room.RoomArticleDTO
import com.adammcneilly.spacenerd.shared.data.article.local.room.RoomArticleDao

@Database(
    version = 1,
    entities = [
        RoomArticleDTO::class,
    ],
)
@ConstructedBy(SpaceNerdDatabaseConstructor::class)
abstract class SpaceNerdDatabase : RoomDatabase() {
    abstract fun articleDao(): RoomArticleDao
}

/**
 * The Room compiler generates the `actual` implementations.
 */
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object SpaceNerdDatabaseConstructor : RoomDatabaseConstructor<SpaceNerdDatabase> {
    override fun initialize(): SpaceNerdDatabase
}
