package com.adammcneilly.spacenerd.shared.di

import com.adammcneilly.spacenerd.shared.data.article.ArticleRepository
import com.adammcneilly.spacenerd.shared.data.article.OfflineFirstArticleRepository
import com.adammcneilly.spacenerd.shared.data.cache.CacheTimestampRepository
import com.adammcneilly.spacenerd.shared.data.cache.local.room.RoomCacheTimestampRepository

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
}
