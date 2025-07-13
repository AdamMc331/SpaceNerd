package com.adammcneilly.spacenerd.shared.di

import com.adammcneilly.spacenerd.data.remote.tsd.dtos.TSDKtorClient
import com.adammcneilly.spacenerd.shared.data.agency.remote.RemoteAgencyService
import com.adammcneilly.spacenerd.shared.data.agency.remote.tsd.TSDAgencyService
import com.adammcneilly.spacenerd.shared.data.article.remote.RemoteArticleService
import com.adammcneilly.spacenerd.shared.data.article.remote.snapi.SNAPIArticleService
import com.adammcneilly.spacenerd.shared.data.article.remote.snapi.SNAPIKtorClient
import com.adammcneilly.spacenerd.shared.data.launch.remote.RemoteLaunchService
import com.adammcneilly.spacenerd.shared.data.launch.remote.tsd.TSDLaunchService
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
}
