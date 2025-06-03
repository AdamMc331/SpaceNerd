package com.adammcneilly.spacenerd.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
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

    companion object {
        @Volatile
        private var INSTANCE: SpaceNerdDatabase? = null

        fun getDatabase(
            context: Context,
        ): SpaceNerdDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SpaceNerdDatabase::class.java,
                    "space_nerd_database", // Name your database file
                )
                    .fallbackToDestructiveMigration(
                        dropAllTables = true,
                    )
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
