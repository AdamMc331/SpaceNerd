package com.adammcneilly.spacenerd.shared.navigation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NavItem(
    val tab: HomeTab,
    val selected: Boolean,
) : Parcelable
