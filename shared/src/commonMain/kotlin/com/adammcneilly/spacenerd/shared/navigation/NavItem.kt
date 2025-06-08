package com.adammcneilly.spacenerd.shared.navigation

import com.adammcneilly.spacenerd.shared.HomeTab

data class NavItem(
    val tab: HomeTab,
    val selected: Boolean,
)
