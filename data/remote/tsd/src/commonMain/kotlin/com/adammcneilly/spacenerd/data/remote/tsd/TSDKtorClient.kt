package com.adammcneilly.spacenerd.data.remote.tsd

import com.adammcneilly.spacenerd.data.remote.ktor.BaseKtorClient

/**
 * Implementation of [BaseKtorClient] that will make requests to the TSD API.
 *
 * Docs here: https://ll.thespacedevs.com/2.3.0/
 */
object TSDKtorClient : BaseKtorClient("https://lldev.thespacedevs.com/2.3.0/") {
    override fun baseParams(): Map<String, Any?> {
        return mapOf(
            "mode" to "detailed",
        )
    }
}
