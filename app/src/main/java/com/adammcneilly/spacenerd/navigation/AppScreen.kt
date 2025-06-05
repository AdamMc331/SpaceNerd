package com.adammcneilly.spacenerd.navigation

import com.adammcneilly.spacenerd.scaffold.HomeTab

sealed interface AppScreen {
    data class Tab(
        val tab: HomeTab,
    ) : AppScreen

    data class LaunchDetail(
        val id: String,
    ) : AppScreen
}
