package com.adammcneilly.spacenerd.shared.di

import com.adammcneilly.spacenerd.data.agency.local.LocalAgencyService
import com.adammcneilly.spacenerd.data.agency.local.room.RoomAgencyService
import com.adammcneilly.spacenerd.data.article.api.local.LocalArticleService
import com.adammcneilly.spacenerd.data.article.impl.local.room.RoomArticleService
import com.adammcneilly.spacenerd.data.launch.local.LocalLaunchService
import com.adammcneilly.spacenerd.data.launch.local.room.RoomLaunchService
import com.adammcneilly.spacenerd.data.local.room.SpaceNerdDatabase
import com.adammcneilly.spacenerd.data.local.room.getDatabase
import org.koin.dsl.module

val localModule = module {
    single<SpaceNerdDatabase> {
        getDatabase()
    }

    single<LocalAgencyService> {
        RoomAgencyService(
            agencyDao = get<SpaceNerdDatabase>().agencyDao(),
        )
    }

    single<LocalArticleService> {
        RoomArticleService(
            articleDao = get<SpaceNerdDatabase>().articleDao(),
        )
    }

    single<LocalLaunchService> {
        RoomLaunchService(
            launchDao = get<SpaceNerdDatabase>().launchDao(),
            dateTimeProvider = get(),
        )
    }
}
