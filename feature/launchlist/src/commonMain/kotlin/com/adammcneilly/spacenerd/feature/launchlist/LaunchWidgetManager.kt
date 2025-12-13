package com.adammcneilly.spacenerd.feature.launchlist

interface LaunchWidgetManager {
    fun launchWidgetSupported(): Boolean

    suspend fun requestPinWidget(): Boolean
}
