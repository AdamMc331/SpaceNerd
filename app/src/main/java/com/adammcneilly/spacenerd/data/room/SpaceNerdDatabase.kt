package com.adammcneilly.spacenerd.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.adammcneilly.spacenerd.data.room.daos.ArticleDao
import com.adammcneilly.spacenerd.data.room.daos.CacheTimestampDao
import com.adammcneilly.spacenerd.data.room.dtos.RoomArticleDTO
import com.adammcneilly.spacenerd.data.room.dtos.RoomCacheTimestampDTO

@Database(
    entities = [
        RoomCacheTimestampDTO::class,
        RoomArticleDTO::class,
    ],
    version = 1,
    exportSchema = true,
)
abstract class SpaceNerdDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao

    abstract fun cacheTimestampDao(): CacheTimestampDao
}
