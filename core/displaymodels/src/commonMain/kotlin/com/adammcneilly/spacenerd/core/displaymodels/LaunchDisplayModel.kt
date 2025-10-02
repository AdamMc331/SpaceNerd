package com.adammcneilly.spacenerd.core.displaymodels

import com.adammcneilly.spacenerd.core.designsystem.models.ImageModel
import com.adammcneilly.spacenerd.core.models.Launch
import com.adammcneilly.spacenerd.core.models.LaunchStatus

/**
 * A user-friendly representation of a rocket launch.
 *
 * @property[id] A unique identifier for this launch.
 * @property[name] The name of this launch.
 * @property[image] The image for this launch.
 * @property[status] The current status of this launch, such as "Go" or "TBD".
 * @property[subtitle] A summary of information about this launch, including the agency and location.
 * @property[agency] The space agency responsible for this launch.
 * @property[mission] The mission this launch is a part of.
 * @property[isPlaceholder] If true, this display model is just a placeholder and the UI
 * should reflect that.
 */
data class LaunchDisplayModel(
    val id: String,
    val name: String,
    val image: ImageModel,
    val status: StatusDisplayModel,
    val subtitle: String,
    val agency: AgencyDisplayModel?,
    val mission: MissionDisplayModel?,
    val rocket: RocketDisplayModel?,
    val isPlaceholder: Boolean = false,
) {
    constructor(launch: Launch) : this(
        id = launch.id,
        name = launch.name,
        image = ImageModel.Remote(launch.imageUrl),
        status = StatusDisplayModel(launch.status),
        agency = launch.agency?.let(::AgencyDisplayModel),
        subtitle = launch.buildSubtitle(),
        mission = launch.mission?.let(::MissionDisplayModel),
        rocket = launch.rocket?.let(::RocketDisplayModel),
    )

    companion object {
        fun placeholder(): LaunchDisplayModel {
            return LaunchDisplayModel(
                id = "",
                name = "Placeholder Launch Name",
                image = ImageModel.Remote(""),
                status = StatusDisplayModel(LaunchStatus.Unknown),
                subtitle = "Placeholder Subtitle",
                agency = AgencyDisplayModel.placeholder(),
                mission = MissionDisplayModel.placeholder(),
                rocket = RocketDisplayModel.placeholder(),
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
