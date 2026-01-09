package com.adammcneilly.spacenerd.core.displaymodels

import com.adammcneilly.spacenerd.core.designsystem.models.ImageModel
import com.adammcneilly.spacenerd.core.models.Launch
import com.adammcneilly.spacenerd.core.models.LaunchStatus
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format
import kotlinx.datetime.format.MonthNames
import kotlinx.datetime.format.char
import kotlinx.datetime.toLocalDateTime

private val launchDateFormat = LocalDateTime.Format {
    monthName(MonthNames.ENGLISH_FULL)
    char(' ')
    day()
    chars(", ")
    year()
    chars(" - ")
    hour()
    char(':')
    minute()
    char(':')
    second()
}

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
    val launchTime: String,
    val agency: AgencyDisplayModel?,
    val mission: MissionDisplayModel?,
    val rocket: RocketDisplayModel?,
    val launchPad: LaunchPadDisplayModel?,
    val isPlaceholder: Boolean = false,
) {
    constructor(
        launch: Launch,
        timeZone: TimeZone,
    ) : this(
        id = launch.id,
        name = launch.name,
        image = ImageModel.Remote(launch.imageUrl),
        status = StatusDisplayModel(launch.status),
        launchTime = launch.launchTime
            .toLocalDateTime(timeZone)
            .format(launchDateFormat),
        agency = launch.agency?.let(::AgencyDisplayModel),
        subtitle = launch.buildSubtitle(),
        mission = launch.mission?.let(::MissionDisplayModel),
        rocket = launch.rocket?.let(::RocketDisplayModel),
        launchPad = launch.pad?.let(::LaunchPadDisplayModel),
    )

    companion object {
        fun placeholder(): LaunchDisplayModel {
            return LaunchDisplayModel(
                id = "",
                name = "Placeholder Launch Name",
                image = ImageModel.Remote(""),
                status = StatusDisplayModel(LaunchStatus.Unknown),
                subtitle = "Placeholder Subtitle",
                launchTime = "January 08, 2026 - 00:00:00",
                agency = AgencyDisplayModel.placeholder(),
                mission = MissionDisplayModel.placeholder(),
                rocket = RocketDisplayModel.placeholder(),
                launchPad = LaunchPadDisplayModel.placeholder(),
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
