package com.adammcneilly.spacenerd.shared.di

import com.adammcneilly.spacenerd.data.agency.api.local.LocalAgencyService
import com.adammcneilly.spacenerd.data.agency.impl.local.room.RoomAgencyService
import com.adammcneilly.spacenerd.data.article.api.local.LocalArticleService
import com.adammcneilly.spacenerd.data.article.impl.local.room.RoomArticleService
import com.adammcneilly.spacenerd.data.astronauts.api.local.LocalAstronautService
import com.adammcneilly.spacenerd.data.astronauts.impl.local.room.RoomAstronautService
import com.adammcneilly.spacenerd.data.expeditions.api.local.LocalExpeditionService
import com.adammcneilly.spacenerd.data.expeditions.impl.local.room.RoomExpeditionService
import com.adammcneilly.spacenerd.data.launch.api.local.LocalLaunchService
import com.adammcneilly.spacenerd.data.launch.impl.local.room.RoomLaunchService
import com.adammcneilly.spacenerd.data.local.room.SpaceNerdDatabase
import com.adammcneilly.spacenerd.data.local.room.getDatabase
import com.adammcneilly.spacenerd.data.stations.api.local.LocalSpaceStationService
import com.adammcneilly.spacenerd.data.stations.impl.local.RoomSpaceStationService
import org.koin.dsl.module

val localModule = module {
    single<SpaceNerdDatabase> {
        getDatabase(
            builderProvider = get(),
        )
    }

    single<LocalAgencyService> {
        RoomAgencyService(
            agencyDao = get<SpaceNerdDatabase>().agencyDao(),
        )
    }

    single<LocalArticleService> {
        RoomArticleService(
            articleDao = get<SpaceNerdDatabase>().articleDao(),
            dateTimeProvider = get(),
        )
    }

    single<LocalAstronautService> {
        RoomAstronautService(
            astronautDao = get<SpaceNerdDatabase>().astronautDao(),
        )
    }

    single<LocalExpeditionService> {
        RoomExpeditionService(
            expeditionDao = get<SpaceNerdDatabase>().expeditionDao(),
            dateTimeProvider = get(),
        )
    }

    single<LocalLaunchService> {
        RoomLaunchService(
            launchDao = get<SpaceNerdDatabase>().launchDao(),
            dateTimeProvider = get(),
        )
    }

    single<LocalSpaceStationService> {
        RoomSpaceStationService(
            spaceStationDao = get<SpaceNerdDatabase>().spaceStationDao(),
        )
    }
}
