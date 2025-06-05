package com.adammcneilly.spacenerd.core.ui.scaffold.navigation

import android.os.Parcelable
import com.adammcneilly.spacenerd.core.ui.scaffold.HomeTab
import kotlinx.parcelize.Parcelize

@Parcelize
data class NavItem(
    val tab: HomeTab,
    val selected: Boolean,
) : Parcelable
