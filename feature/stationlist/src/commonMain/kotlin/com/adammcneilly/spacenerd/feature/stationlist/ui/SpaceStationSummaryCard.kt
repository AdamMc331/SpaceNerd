package com.adammcneilly.spacenerd.feature.stationlist.ui

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import com.adammcneilly.spacenerd.core.designsystem.components.ImageContentCard
import com.adammcneilly.spacenerd.core.designsystem.components.ImageContentCardConfig
import com.adammcneilly.spacenerd.core.designsystem.components.ImageContentCardSize
import com.adammcneilly.spacenerd.core.designsystem.utils.currentWindowWidthSizeClass
import com.adammcneilly.spacenerd.core.displaymodels.SpaceStationDisplayModel

@Composable
fun SpaceStationSummaryCard(
    station: SpaceStationDisplayModel,
    modifier: Modifier = Modifier,
) {
    val isAtLeastMediumWidth = currentWindowWidthSizeClass() in listOf(
        WindowWidthSizeClass.Medium,
        WindowWidthSizeClass.Expanded,
    )

    val size = if (isAtLeastMediumWidth) {
        ImageContentCardSize.Expanded
    } else {
        ImageContentCardSize.Compact
    }

    ImageContentCard(
        config = ImageContentCardConfig(
            image = station.image,
            title = AnnotatedString(station.name),
            subtitle = null,
            placeholder = station.isPlaceholder,
            transitionKeyPrefix = "Station-${station.id}",
            status = ImageContentCardConfig.StatusConfig(
                text = station.status.label,
                contentColor = station.status.contentColor,
                containerColor = station.status.containerColor,
            ),
            size = size,
        ),
        modifier = modifier,
    )
}
