package com.adammcneilly.spacenerd.core.ui.scaffold.navigation

import com.adammcneilly.spacenerd.core.ui.scaffold.HomeTab
import com.adammcneilly.spacenerd.core.ui.scaffold.Parcelize

@Parcelize
data class NavItem(
    val tab: HomeTab,
    val selected: Boolean,
)
