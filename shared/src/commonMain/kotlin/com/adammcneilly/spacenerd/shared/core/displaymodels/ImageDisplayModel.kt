package com.adammcneilly.spacenerd.shared.core.displaymodels

import androidx.annotation.DrawableRes

sealed interface ImageDisplayModel {
    data class Remote(
        val url: String,
    ) : ImageDisplayModel

    data class Local(
        @DrawableRes
        val resource: Int,
    ) : ImageDisplayModel
}
