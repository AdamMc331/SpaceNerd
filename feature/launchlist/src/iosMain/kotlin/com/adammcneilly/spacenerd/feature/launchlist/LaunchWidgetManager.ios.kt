package com.adammcneilly.spacenerd.feature.launchlist

class IOSLaunchWidgetManager : LaunchWidgetManager {
    override fun launchWidgetSupported(): Boolean {
        return false
    }

    override suspend fun requestPinWidget(): Boolean {
        return false
    }
}
