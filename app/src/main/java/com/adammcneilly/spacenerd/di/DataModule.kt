package com.adammcneilly.spacenerd.di

import com.adammcneilly.spacenerd.data.repositories.ArticleRepository
import com.adammcneilly.spacenerd.data.repositories.LaunchRepository
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
        articleRepository: SpaceFlightNewsArticleRepository,
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
}
