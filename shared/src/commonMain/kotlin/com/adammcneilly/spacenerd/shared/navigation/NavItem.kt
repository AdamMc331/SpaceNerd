package com.adammcneilly.spacenerd.shared.navigation

import com.adammcneilly.spacenerd.shared.navigation.HomeTab

data class NavItem(
    val tab: HomeTab,
    val selected: Boolean,
)
