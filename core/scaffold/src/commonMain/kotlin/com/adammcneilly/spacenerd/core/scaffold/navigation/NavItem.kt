package com.adammcneilly.spacenerd.core.scaffold.navigation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NavItem(
    val tab: HomeTab,
    val selected: Boolean,
) : Parcelable
