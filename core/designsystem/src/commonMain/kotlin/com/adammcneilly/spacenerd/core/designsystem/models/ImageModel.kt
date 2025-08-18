package com.adammcneilly.spacenerd.core.designsystem.models

import org.jetbrains.compose.resources.DrawableResource

/**
 * A sealed interface that represents an image that can be loaded either remotely or locally.
 */
sealed interface ImageModel {
    /**
     * Represents an image that is loaded from a remote URL.
     *
     * @property url The URL of the image to load.
     */
    data class Remote(
        val url: String,
    ) : ImageModel

    /**
     * Represents an image that is loaded from a local drawable resource.
     *
     * @property resource The drawable resource to load.
     */
    data class Local(
        val resource: DrawableResource,
    ) : ImageModel

    /**
     * Typically only used in previews, this will be used
     * when we don't have an actual image to supply.
     */
    data object Placeholder : ImageModel
}
