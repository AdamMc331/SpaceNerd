package com.adammcneilly.spacenerd.feature.stationlist.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.adammcneilly.spacenerd.core.designsystem.components.ImageContentCard
import com.adammcneilly.spacenerd.core.designsystem.components.ImageContentCardConfig
import com.adammcneilly.spacenerd.core.displaymodels.SpaceStationDisplayModel

@Composable
fun SpaceStationSummaryCard(
    station: SpaceStationDisplayModel,
    modifier: Modifier = Modifier,
) {
    ImageContentCard(
        config = ImageContentCardConfig(
            image = station.image,
            title = station.name,
            subtitle = null,
            placeholder = station.isPlaceholder,
            transitionKeyPrefix = "Station-${station.id}",
            status = ImageContentCardConfig.StatusConfig(
                text = station.status.label,
                contentColor = station.status.contentColor,
                containerColor = station.status.containerColor,
            ),
        ),
        modifier = modifier,
    )
}
