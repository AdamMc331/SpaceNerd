package com.adammcneilly.spacenerd.core.displaymodels

import com.adammcneilly.spacenerd.core.designsystem.models.ImageModel
import com.adammcneilly.spacenerd.core.models.Astronaut

/**
 * User friendly representation of an [Astronaut].
 */
data class AstronautDisplayModel(
    val id: String,
    val name: String,
    val image: ImageModel,
    val placeholder: Boolean = false,
) {

    constructor(
        astronaut: Astronaut,
    ): this(
        id = astronaut.id,
        name = astronaut.name,
        image = ImageModel.Remote(astronaut.imageUrl),
    )

    companion object {
        fun placeholder(): AstronautDisplayModel {
            return AstronautDisplayModel(
                id = "",
                name = "Placeholder Astronaut",
                image = ImageModel.Placeholder,
                placeholder = true,
            )
        }
    }
}
