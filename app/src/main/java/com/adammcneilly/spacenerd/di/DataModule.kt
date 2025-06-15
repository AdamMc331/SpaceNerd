package com.adammcneilly.spacenerd.di

import com.adammcneilly.spacenerd.shared.data.launch.LaunchRepository
import com.adammcneilly.spacenerd.shared.di.RepositoryDependencies
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
    fun provideArticleRepository(): com.adammcneilly.spacenerd.shared.data.article.ArticleRepository {
        return RepositoryDependencies.articleRepository
    }

    @Provides
    @Singleton
    fun provideLaunchRepository(): LaunchRepository {
        return RepositoryDependencies.launchRepository
    }
}
