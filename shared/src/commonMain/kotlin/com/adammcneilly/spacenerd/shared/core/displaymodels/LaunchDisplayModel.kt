package com.adammcneilly.spacenerd.shared.core.displaymodels

import com.adammcneilly.spacenerd.shared.core.models.Launch
import com.adammcneilly.spacenerd.shared.core.models.LaunchStatus

data class LaunchDisplayModel(
    val id: String,
    val name: String,
    val image: ImageDisplayModel,
    val status: LaunchStatusDisplayModel,
    val subtitle: String,
    val agency: AgencyDisplayModel?,
    val isPlaceholder: Boolean = false,
) {
    constructor(launch: Launch) : this(
        id = launch.id,
        name = launch.name,
        image = ImageDisplayModel.Remote(launch.imageUrl),
        status = LaunchStatusDisplayModel(launch.status),
        agency = launch.agency?.let(::AgencyDisplayModel),
        subtitle = launch.buildSubtitle(),
    )

    companion object {
        fun placeholder(): LaunchDisplayModel {
            return LaunchDisplayModel(
                id = "",
                name = "Placeholder Launch Name",
                image = ImageDisplayModel.Remote(""),
                status = LaunchStatusDisplayModel(LaunchStatus.Unknown),
                subtitle = "Placeholder Subtitle",
                agency = AgencyDisplayModel.placeholder(),
                isPlaceholder = true,
            )
        }
    }
}

private fun Launch.buildSubtitle(): String {
    val agencyName = this.agency?.name
    val locationName = this.pad?.location?.name

    return listOfNotNull(agencyName, locationName).joinToString(" • ")
}
