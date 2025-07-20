package com.adammcneilly.spacenerd.core.designsystem.models

import org.jetbrains.compose.resources.DrawableResource

sealed interface ImageModel {
    data class Remote(
        val url: String,
    ) : ImageModel

    data class Local(
        val resource: DrawableResource,
    ) : ImageModel

    /**
     * Typically only used in previews, this will be used
     * when we don't have an actual image to supply.
     */
    data object Placeholder : ImageModel
}
