package com.adammcneilly.spacenerd.navigation

import androidx.navigation3.runtime.NavKey
import com.adammcneilly.spacenerd.core.scaffold.navigation.HomeTab
import kotlinx.serialization.Serializable

sealed class AppScreen : NavKey {
    @Serializable
    data class Tab(
        val tab: HomeTab,
    ) : AppScreen()

    @Serializable
    data class LaunchDetail(
        val launchId: String,
    ) : AppScreen()
}
