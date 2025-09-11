package com.adammcneilly.spacenerd.shared.di

import com.adammcneilly.spacenerd.data.agency.api.AgencyRepository
import com.adammcneilly.spacenerd.data.agency.impl.OfflineFirstAgencyRepository
import com.adammcneilly.spacenerd.data.article.api.ArticleRepository
import com.adammcneilly.spacenerd.data.article.impl.OfflineFirstArticleRepository
import com.adammcneilly.spacenerd.data.cache.CacheTimestampRepository
import com.adammcneilly.spacenerd.data.cache.room.RoomCacheTimestampRepository
import com.adammcneilly.spacenerd.data.expeditions.api.ExpeditionRepository
import com.adammcneilly.spacenerd.data.expeditions.impl.OfflineFirstExpeditionRepository
import com.adammcneilly.spacenerd.data.launch.api.LaunchRepository
import com.adammcneilly.spacenerd.data.launch.impl.OfflineFirstLaunchRepository
import com.adammcneilly.spacenerd.data.local.room.SpaceNerdDatabase
import com.adammcneilly.spacenerd.data.stations.api.SpaceStationRepository
import com.adammcneilly.spacenerd.data.stations.impl.OfflineFirstSpaceStationRepository
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

    single<ExpeditionRepository> {
        OfflineFirstExpeditionRepository(
            localExpeditionService = get(),
            remoteExpeditionService = get(),
            cacheTimestampRepository = get(),
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

    single<SpaceStationRepository> {
        OfflineFirstSpaceStationRepository(
            localSpaceStationService = get(),
            remoteSpaceStationService = get(),
            cacheTimestampRepository = get(),
        )
    }
}
