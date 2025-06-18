package com.adammcneilly.spacenerd.shared.di

import com.adammcneilly.spacenerd.shared.data.article.ArticleRepository
import com.adammcneilly.spacenerd.shared.data.article.OfflineFirstArticleRepository
import com.adammcneilly.spacenerd.shared.data.cache.CacheTimestampRepository
import com.adammcneilly.spacenerd.shared.data.cache.local.room.RoomCacheTimestampRepository
import com.adammcneilly.spacenerd.shared.data.launch.LaunchRepository
import com.adammcneilly.spacenerd.shared.data.launch.OfflineFirstLaunchRepository
import com.adammcneilly.spacenerd.shared.data.local.room.SpaceNerdDatabase
import org.koin.dsl.module

val repositoryModule = module {
    single<CacheTimestampRepository> {
        RoomCacheTimestampRepository(
            dateTimeProvider = get(),
            cacheTimestampDao = get<SpaceNerdDatabase>().cacheTimestampDao(),
        )
    }

    single<ArticleRepository> {
        OfflineFirstArticleRepository(
            localArticleService = get(),
            remoteArticleService = get(),
            cacheTimestampRepository = get(),
        )
    }

    single<LaunchRepository> {
        OfflineFirstLaunchRepository(
            localLaunchService = get(),
            remoteLaunchService = get(),
            cacheTimestampRepository = get(),
        )
    }
}

object RepositoryDependencies {
    val cacheTimestampRepository: CacheTimestampRepository by lazy {
        RoomCacheTimestampRepository(
            dateTimeProvider = UtilDependencies.dateTimeProvider,
            cacheTimestampDao = LocalDataDependencies.roomDatabase.cacheTimestampDao(),
        )
    }
    val articleRepository: ArticleRepository by lazy {
        OfflineFirstArticleRepository(
            localArticleService = LocalDataDependencies.localArticleService,
            remoteArticleService = RemoteDataDependencies.remoteArticleService,
            cacheTimestampRepository = cacheTimestampRepository,
        )
    }

    val launchRepository: LaunchRepository by lazy {
        OfflineFirstLaunchRepository(
            localLaunchService = LocalDataDependencies.localLaunchService,
            remoteLaunchService = RemoteDataDependencies.remoteLaunchService,
            cacheTimestampRepository = cacheTimestampRepository,
        )
    }
}
