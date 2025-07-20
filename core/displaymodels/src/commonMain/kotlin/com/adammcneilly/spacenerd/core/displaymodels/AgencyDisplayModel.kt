package com.adammcneilly.spacenerd.core.displaymodels

import com.adammcneilly.spacenerd.core.designsystem.models.ImageModel
import com.adammcneilly.spacenerd.core.models.Agency

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
