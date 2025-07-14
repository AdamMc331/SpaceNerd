package com.adammcneilly.spacenerd.shared.data.article.remote.snapi

import com.adammcneilly.spacenerd.data.remote.ktor.BaseKtorClient

object SNAPIKtorClient : BaseKtorClient(
    baseUrl = "https://api.spaceflightnewsapi.net/",
)
