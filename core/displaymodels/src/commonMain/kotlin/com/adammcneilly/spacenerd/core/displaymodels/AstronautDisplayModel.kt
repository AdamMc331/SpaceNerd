package com.adammcneilly.spacenerd.core.displaymodels

import com.adammcneilly.spacenerd.core.designsystem.models.ImageModel
import com.adammcneilly.spacenerd.core.models.Astronaut

/**
 * User friendly representation of an [Astronaut].
 */
data class AstronautDisplayModel(
    val id: String,
    val name: String,
    val bio: String,
    val image: ImageModel,
    val agency: AgencyDisplayModel?,
    val placeholder: Boolean = false,
) {
    constructor(
        astronaut: Astronaut,
    ) : this(
        id = astronaut.id,
        name = astronaut.name,
        bio = astronaut.bio,
        image = ImageModel.Remote(astronaut.imageUrl),
        agency = astronaut.agency?.let(::AgencyDisplayModel),
    )

    companion object {
        fun placeholder(): AstronautDisplayModel {
            return AstronautDisplayModel(
                id = "",
                name = "Placeholder Astronaut",
                bio = "Placeholder Bio",
                image = ImageModel.Placeholder,
                agency = AgencyDisplayModel.placeholder(),
                placeholder = true,
            )
        }
    }
}
