package com.adammcneilly.spacenerd.di

import com.adammcneilly.spacenerd.data.repositories.ArticleRepository
import com.adammcneilly.spacenerd.data.spaceflightnews.SpaceFlightNewsArticleRepository
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
    ): ArticleRepository = articleRepository
}
