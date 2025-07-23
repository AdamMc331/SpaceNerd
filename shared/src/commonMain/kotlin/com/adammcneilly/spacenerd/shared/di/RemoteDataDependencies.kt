package com.adammcneilly.spacenerd.shared.di

import com.adammcneilly.spacenerd.data.agency.api.remote.RemoteAgencyService
import com.adammcneilly.spacenerd.data.agency.impl.remote.tsd.TSDAgencyService
import com.adammcneilly.spacenerd.data.article.api.remote.RemoteArticleService
import com.adammcneilly.spacenerd.data.article.impl.remote.snapi.SNAPIArticleService
import com.adammcneilly.spacenerd.data.launch.api.remote.RemoteLaunchService
import com.adammcneilly.spacenerd.data.launch.impl.remote.tsd.TSDLaunchService
import com.adammcneilly.spacenerd.data.remote.snapi.SNAPIKtorClient
import com.adammcneilly.spacenerd.data.remote.tsd.dtos.TSDKtorClient
import com.adammcneilly.spacenerd.data.stations.api.remote.RemoteSpaceStationService
import com.adammcneilly.spacenerd.data.stations.impl.remote.TSDSpaceStationService
import org.koin.dsl.module

val remoteModule = module {
    single<RemoteAgencyService> {
        TSDAgencyService(
            client = TSDKtorClient,
        )
    }

    single<RemoteArticleService> {
        SNAPIArticleService(
            client = SNAPIKtorClient,
        )
    }

    single<RemoteLaunchService> {
        TSDLaunchService(
            client = TSDKtorClient,
        )
    }

    single<RemoteSpaceStationService> {
        TSDSpaceStationService(
            client = TSDKtorClient,
        )
    }
}
