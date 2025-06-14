package com.adammcneilly.spacenerd.shared.di

import com.adammcneilly.spacenerd.shared.data.article.remote.RemoteArticleService
import com.adammcneilly.spacenerd.shared.data.article.remote.snapi.SNAPIArticleService
import com.adammcneilly.spacenerd.shared.data.article.remote.snapi.SNAPIKtorClient

object RemoteDataDependencies {
    val remoteArticleService: RemoteArticleService by lazy {
        SNAPIArticleService(
            client = SNAPIKtorClient,
        )
    }
}
