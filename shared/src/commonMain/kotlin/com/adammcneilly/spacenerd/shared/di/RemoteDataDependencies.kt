package com.adammcneilly.spacenerd.shared.di

import com.adammcneilly.spacenerd.shared.data.article.remote.RemoteArticleService
import com.adammcneilly.spacenerd.shared.data.article.remote.snapi.SNAPIArticleService
import com.adammcneilly.spacenerd.shared.data.article.remote.snapi.SNAPIKtorClient
import com.adammcneilly.spacenerd.shared.data.launch.remote.RemoteLaunchService
import com.adammcneilly.spacenerd.shared.data.launch.remote.tsd.TSDKtorClient
import com.adammcneilly.spacenerd.shared.data.launch.remote.tsd.TSDLaunchService
import org.koin.dsl.module

val remoteModule = module {
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

object RemoteDataDependencies {
    val remoteArticleService: RemoteArticleService by lazy {
        SNAPIArticleService(
            client = SNAPIKtorClient,
        )
    }

    val remoteLaunchService: RemoteLaunchService by lazy {
        TSDLaunchService(
            client = TSDKtorClient,
        )
    }
}
