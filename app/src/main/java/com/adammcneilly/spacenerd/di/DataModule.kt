package com.adammcneilly.spacenerd.di

import com.adammcneilly.spacenerd.data.repositories.ArticleRepository
import com.adammcneilly.spacenerd.data.repositories.CacheTimestampRepository
import com.adammcneilly.spacenerd.data.repositories.LaunchRepository
import com.adammcneilly.spacenerd.data.repositories.LocalArticleRepository
import com.adammcneilly.spacenerd.data.repositories.OfflineFirstArticleRepository
import com.adammcneilly.spacenerd.data.repositories.RemoteArticleRepository
import com.adammcneilly.spacenerd.data.room.repositories.RoomArticleRepository
import com.adammcneilly.spacenerd.data.room.repositories.RoomCacheTimestampRepository
import com.adammcneilly.spacenerd.data.spaceflightnews.SpaceFlightNewsArticleRepository
import com.adammcneilly.spacenerd.data.thespacedevs.TSDLaunchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideArticleRepository(
        articleRepository: OfflineFirstArticleRepository,
    ): ArticleRepository {
        return articleRepository
    }

    @Provides
    @Singleton
    fun provideLaunchRepository(
        launchRepository: TSDLaunchRepository,
    ): LaunchRepository {
        return launchRepository
    }

    @Provides
    @Singleton
    fun provideCacheTimestampRepository(
        cacheTimestampRepository: RoomCacheTimestampRepository,
    ): CacheTimestampRepository {
        return cacheTimestampRepository
    }

    @Provides
    @Singleton
    fun provideLocalArticleRepository(
        localArticleRepository: RoomArticleRepository,
    ): LocalArticleRepository {
        return localArticleRepository
    }

    @Provides
    @Singleton
    fun provideRemoteArticleRepository(
        remoteArticleRepository: SpaceFlightNewsArticleRepository,
    ): RemoteArticleRepository {
        return remoteArticleRepository
    }
}
