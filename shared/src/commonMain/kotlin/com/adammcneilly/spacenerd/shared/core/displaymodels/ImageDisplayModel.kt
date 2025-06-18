package com.adammcneilly.spacenerd.shared.core.displaymodels

import org.jetbrains.compose.resources.DrawableResource

sealed interface ImageDisplayModel {
    data class Remote(
        val url: String,
    ) : ImageDisplayModel

    data class AndroidLocal(
        val drawableRes: Int,
    ) : ImageDisplayModel

    data class Local(
        val resource: DrawableResource,
    ) : ImageDisplayModel

    /**
     * Typically only used in previews, this will be used
     * when we don't have an actual image to supply.
     */
    data object Placeholder : ImageDisplayModel
}
