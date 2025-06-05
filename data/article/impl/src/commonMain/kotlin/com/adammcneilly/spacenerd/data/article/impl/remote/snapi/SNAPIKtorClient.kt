package com.adammcneilly.spacenerd.data.article.impl.remote.snapi

import com.adammcneilly.spacenerd.core.data.ktor.BaseKtorClient

object SNAPIKtorClient : BaseKtorClient(
    baseUrl = "https://api.spaceflightnewsapi.net/",
)
