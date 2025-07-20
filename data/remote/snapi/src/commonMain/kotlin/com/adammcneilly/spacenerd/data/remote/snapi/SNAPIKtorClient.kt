package com.adammcneilly.spacenerd.data.remote.snapi

import com.adammcneilly.spacenerd.data.remote.ktor.BaseKtorClient

object SNAPIKtorClient : BaseKtorClient(
    baseUrl = "https://api.spaceflightnewsapi.net/",
)
