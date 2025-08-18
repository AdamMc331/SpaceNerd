package com.adammcneilly.spacenerd.core.displaymodels

import com.adammcneilly.spacenerd.core.designsystem.models.ImageModel
import com.adammcneilly.spacenerd.core.models.Agency

/**
 * A user-friendly representation of a space agency.
 *
 * @property[id] A unique identifier for this agency.
 * @property[name] The name of this agency.
 * @property[description] A brief summary of this agency and what they do.
 * @property[logo] The image logo for this agency.
 * @property[isPlaceholder] If true, this display model is just a placeholder and the UI
 * should reflect that.
 */
data class AgencyDisplayModel(
    val id: String,
    val name: String,
    val description: String,
    val logo: ImageModel,
    val isPlaceholder: Boolean = false,
) {
    constructor(
        agency: Agency,
    ) : this(
        id = agency.id,
        name = agency.name,
        description = agency.description,
        logo = ImageModel.Remote(agency.logoUrl),
    )

    companion object {
        fun placeholder(): AgencyDisplayModel {
            return AgencyDisplayModel(
                id = "",
                name = "Agency Name",
                description = "Agency description is kinda long\nand definitely expands multiple\nnew lines",
                logo = ImageModel.Placeholder,
                isPlaceholder = true,
            )
        }
    }
}
