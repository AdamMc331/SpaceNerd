package com.adammcneilly.spacenerd.scaffold.navigation

import android.os.Parcelable
import com.adammcneilly.spacenerd.scaffold.HomeTab
import kotlinx.parcelize.Parcelize

@Parcelize
data class NavItem(
    val tab: HomeTab,
    val selected: Boolean,
) : Parcelable
