package com.adammcneilly.spacenerd.core.displaymodels

import androidx.compose.ui.graphics.Color
import com.adammcneilly.spacenerd.core.designsystem.theme.SpaceNerdColors
import com.adammcneilly.spacenerd.core.models.AstronautStatus
import com.adammcneilly.spacenerd.core.models.LaunchStatus
import com.adammcneilly.spacenerd.core.models.SpaceStationStatus

/**
 * A user-friendly representation of a status badge.
 *
 * @property[label] The text to display inside the status badge.
 * @property[containerColor] The background color of the status badge.
 * @property[contentColor] The text color of the status badge.
 */
data class StatusDisplayModel(
    val label: String,
    val containerColor: Color,
    val contentColor: Color,
) {
    constructor(
        launchStatus: LaunchStatus,
    ) : this(
        label = launchStatus.label().uppercase(),
        containerColor = launchStatus.containerColor(),
        contentColor = Color.White,
    )

    constructor(
        stationStatus: SpaceStationStatus,
    ) : this(
        label = stationStatus.label().uppercase(),
        containerColor = stationStatus.containerColor(),
        contentColor = Color.White,
    )

    constructor(
        astronautStatus: AstronautStatus,
    ) : this(
        label = astronautStatus.label().uppercase(),
        containerColor = astronautStatus.containerColor(),
        contentColor = Color.White,
    )
}

private fun LaunchStatus.label(): String {
    return when (this) {
        LaunchStatus.Go -> "Go"
        LaunchStatus.TBD -> "TBD"
        LaunchStatus.Success -> "Success"
        LaunchStatus.Failure -> "Failure"
        LaunchStatus.Hold -> "Hold"
        LaunchStatus.PartialFailure -> "Partial Failure"
        LaunchStatus.TBC -> "TBC"
        LaunchStatus.InFlight -> "In Flight"
        LaunchStatus.Deployed -> "Payload Deployed"
        LaunchStatus.Unknown -> "Unknown"
    }
}

private fun LaunchStatus.containerColor(): Color {
    return when (this) {
        LaunchStatus.Go -> SpaceNerdColors.Green
        LaunchStatus.TBD -> Color.Gray
        LaunchStatus.Success -> SpaceNerdColors.Green
        LaunchStatus.Failure -> Color.Red
        LaunchStatus.Hold -> Color.Yellow
        LaunchStatus.PartialFailure -> Color.Red
        LaunchStatus.TBC -> Color.Gray
        LaunchStatus.InFlight -> SpaceNerdColors.Green
        LaunchStatus.Deployed -> SpaceNerdColors.Green
        LaunchStatus.Unknown -> Color.Gray
    }
}

private fun SpaceStationStatus.label(): String {
    return when (this) {
        SpaceStationStatus.Active -> "Active"
        SpaceStationStatus.DeOrbited -> "De-Orbited"
        SpaceStationStatus.Decommissioned -> "Decommissioned"
        SpaceStationStatus.Unknown -> "Unknown"
    }
}

private fun SpaceStationStatus.containerColor(): Color {
    return when (this) {
        SpaceStationStatus.Active -> SpaceNerdColors.Green
        SpaceStationStatus.DeOrbited -> Color.DarkGray
        SpaceStationStatus.Decommissioned -> Color.DarkGray
        SpaceStationStatus.Unknown -> Color.Gray
    }
}

private fun AstronautStatus.label(): String {
    return when (this) {
        AstronautStatus.Active -> "Active"
        AstronautStatus.Retired -> "Retired"
        AstronautStatus.InTraining -> "In Training"
        AstronautStatus.Deceased -> "Deceased"
        AstronautStatus.Dismissed -> "Dismissed"
        AstronautStatus.Resigned -> "Resigned"
        AstronautStatus.OccasionalSpaceflight -> "Occasional Spaceflight"
        AstronautStatus.Unknown -> "Unknown"
    }
}

private fun AstronautStatus.containerColor(): Color {
    return when (this) {
        AstronautStatus.Active -> SpaceNerdColors.Green
        AstronautStatus.Retired -> Color.DarkGray
        AstronautStatus.InTraining -> Color.DarkGray
        AstronautStatus.Deceased -> Color.DarkGray
        AstronautStatus.Dismissed -> Color.DarkGray
        AstronautStatus.Resigned -> Color.DarkGray
        AstronautStatus.OccasionalSpaceflight -> Color.DarkGray
        AstronautStatus.Unknown -> Color.Gray
    }
}
