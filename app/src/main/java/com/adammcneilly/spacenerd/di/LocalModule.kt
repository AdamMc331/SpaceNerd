package com.adammcneilly.spacenerd.di

import android.content.Context
import androidx.room.Room
import com.adammcneilly.spacenerd.data.room.SpaceNerdDatabase
import com.adammcneilly.spacenerd.data.room.daos.ArticleDao
import com.adammcneilly.spacenerd.data.room.daos.CacheTimestampDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {
    @Provides
    @Singleton
    fun provideSpaceNerdDatabase(
        @ApplicationContext appContext: Context,
    ): SpaceNerdDatabase {
        return Room
            .databaseBuilder(
                appContext,
                SpaceNerdDatabase::class.java,
                "spacenerd.db",
            )
            // TODO: Eventually replace with migrations, once stable.
            .fallbackToDestructiveMigration(
                dropAllTables = true,
            )
            .build()
    }

    @Provides
    fun provideArticleDao(
        database: SpaceNerdDatabase,
    ): ArticleDao {
        return database.articleDao()
    }

    @Provides
    fun provideCacheTimestampDao(
        database: SpaceNerdDatabase,
    ): CacheTimestampDao {
        return database.cacheTimestampDao()
    }
}
