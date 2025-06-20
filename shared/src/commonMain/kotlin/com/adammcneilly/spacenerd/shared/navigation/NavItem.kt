package com.adammcneilly.spacenerd.shared.navigation

import android.os.Parcelable
import com.adammcneilly.spacenerd.shared.navigation.HomeTab
import kotlinx.parcelize.Parcelize

@Parcelize
data class NavItem(
    val tab: HomeTab,
    val selected: Boolean,
) : Parcelable
