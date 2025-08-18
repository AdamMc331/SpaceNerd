package com.adammcneilly.spacenerd.data.remote.snapi

import com.adammcneilly.spacenerd.data.remote.ktor.BaseKtorClient

/**
 * Implementation of [BaseKtorClient] that will make requests to the Spaceflight News API.
 *
 * Docs here: https://api.spaceflightnewsapi.net/v4/docs/
 */
object SNAPIKtorClient : BaseKtorClient(
    baseUrl = "https://api.spaceflightnewsapi.net/v4/",
)
