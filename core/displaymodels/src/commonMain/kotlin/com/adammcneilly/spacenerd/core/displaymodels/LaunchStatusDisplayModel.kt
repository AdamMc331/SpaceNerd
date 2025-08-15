package com.adammcneilly.spacenerd.core.displaymodels

import androidx.compose.ui.graphics.Color
import com.adammcneilly.spacenerd.core.designsystem.theme.SpaceNerdColors
import com.adammcneilly.spacenerd.core.models.LaunchStatus
import com.adammcneilly.spacenerd.core.models.SpaceStationStatus

data class LaunchStatusDisplayModel(
    val label: String,
    val containerColor: Color,
    val contentColor: Color,
) {
    constructor(
        launchStatus: LaunchStatus,
    ) : this(
        label = launchStatus.label().uppercase(),
        containerColor = launchStatus.containerColor(),
        contentColor = launchStatus.contentColor(),
    )

    constructor(
        stationStatus: SpaceStationStatus,
    ) : this(
        label = stationStatus.label().uppercase(),
        containerColor = stationStatus.containerColor(),
        contentColor = stationStatus.contentColor(),
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

private fun LaunchStatus.contentColor(): Color {
    return Color.White
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

private fun SpaceStationStatus.contentColor(): Color {
    return Color.White
}
