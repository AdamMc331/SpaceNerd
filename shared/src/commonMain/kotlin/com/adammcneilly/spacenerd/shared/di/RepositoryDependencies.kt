package com.adammcneilly.spacenerd.shared.di

import com.adammcneilly.spacenerd.data.agency.AgencyRepository
import com.adammcneilly.spacenerd.data.agency.OfflineFirstAgencyRepository
import com.adammcneilly.spacenerd.data.article.api.ArticleRepository
import com.adammcneilly.spacenerd.data.article.impl.OfflineFirstArticleRepository
import com.adammcneilly.spacenerd.data.cache.CacheTimestampRepository
import com.adammcneilly.spacenerd.data.cache.room.RoomCacheTimestampRepository
import com.adammcneilly.spacenerd.data.launch.LaunchRepository
import com.adammcneilly.spacenerd.data.launch.OfflineFirstLaunchRepository
import com.adammcneilly.spacenerd.data.local.room.SpaceNerdDatabase
import org.koin.dsl.module

val repositoryModule = module {
    single<AgencyRepository> {
        OfflineFirstAgencyRepository(
            localAgencyService = get(),
            remoteAgencyService = get(),
            cacheTimestampRepository = get(),
        )
    }

    single<ArticleRepository> {
        OfflineFirstArticleRepository(
            localArticleService = get(),
            remoteArticleService = get(),
            cacheTimestampRepository = get(),
        )
    }

    single<CacheTimestampRepository> {
        RoomCacheTimestampRepository(
            dateTimeProvider = get(),
            cacheTimestampDao = get<SpaceNerdDatabase>().cacheTimestampDao(),
        )
    }

    single<LaunchRepository> {
        OfflineFirstLaunchRepository(
            localLaunchService = get(),
            remoteLaunchService = get(),
            cacheTimestampRepository = get(),
            localAgencyService = get(),
            remoteAgencyService = get(),
        )
    }
}
