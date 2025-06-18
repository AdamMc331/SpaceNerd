package com.adammcneilly.spacenerd.navigation

import com.adammcneilly.spacenerd.shared.navigation.HomeTab

sealed interface AppScreen {
    data class Tab(
        val tab: HomeTab,
    ) : AppScreen

    data class LaunchDetail(
        val launchId: String,
    ) : AppScreen
}
