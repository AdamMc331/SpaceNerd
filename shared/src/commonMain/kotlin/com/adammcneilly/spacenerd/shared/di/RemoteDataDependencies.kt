package com.adammcneilly.spacenerd.shared.di

import com.adammcneilly.spacenerd.data.agency.remote.RemoteAgencyService
import com.adammcneilly.spacenerd.data.agency.remote.tsd.TSDAgencyService
import com.adammcneilly.spacenerd.data.launch.remote.RemoteLaunchService
import com.adammcneilly.spacenerd.data.launch.remote.tsd.TSDLaunchService
import com.adammcneilly.spacenerd.data.remote.tsd.dtos.TSDKtorClient
import com.adammcneilly.spacenerd.shared.data.article.remote.RemoteArticleService
import com.adammcneilly.spacenerd.shared.data.article.remote.snapi.SNAPIArticleService
import com.adammcneilly.spacenerd.shared.data.article.remote.snapi.SNAPIKtorClient
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
