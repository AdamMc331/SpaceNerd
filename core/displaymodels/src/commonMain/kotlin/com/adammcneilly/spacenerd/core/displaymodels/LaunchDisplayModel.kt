package com.adammcneilly.spacenerd.core.displaymodels

import com.adammcneilly.spacenerd.core.models.Launch
import com.adammcneilly.spacenerd.core.models.LaunchStatus

data class LaunchDisplayModel(
    val id: String,
    val name: String,
    val image: ImageDisplayModel,
    val status: LaunchStatusDisplayModel,
    val subtitle: String,
    val agency: AgencyDisplayModel?,
    val mission: MissionDisplayModel?,
    val isPlaceholder: Boolean = false,
) {
    constructor(launch: Launch) : this(
        id = launch.id,
        name = launch.name,
        image = ImageDisplayModel.Remote(launch.imageUrl),
        status = LaunchStatusDisplayModel(launch.status),
        agency = launch.agency?.let(::AgencyDisplayModel),
        subtitle = launch.buildSubtitle(),
        mission = launch.mission?.let(::MissionDisplayModel),
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
                mission = MissionDisplayModel.placeholder(),
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
