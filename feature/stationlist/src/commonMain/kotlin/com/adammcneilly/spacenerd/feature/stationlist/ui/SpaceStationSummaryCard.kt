package com.adammcneilly.spacenerd.feature.stationlist.ui

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.adammcneilly.spacenerd.core.designsystem.components.ImageContentCard
import com.adammcneilly.spacenerd.core.designsystem.components.ImageWrapper
import com.adammcneilly.spacenerd.core.designsystem.components.Pill
import com.adammcneilly.spacenerd.core.designsystem.utils.currentWindowWidthSizeClass
import com.adammcneilly.spacenerd.core.designsystem.utils.sharedBounds
import com.adammcneilly.spacenerd.core.designsystem.utils.sharedElement
import com.adammcneilly.spacenerd.core.displaymodels.SpaceStationDisplayModel
import com.eygraber.compose.placeholder.PlaceholderDefaults
import com.eygraber.compose.placeholder.material3.color
import com.eygraber.compose.placeholder.material3.placeholder
import com.eygraber.compose.placeholder.placeholder

@OptIn(ExperimentalSharedTransitionApi::class)
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
        ImageContentCard.Size.Expanded
    } else {
        ImageContentCard.Size.Compact
    }

    ImageContentCard(
        image = { modifier ->
            StationImage(
                station = station,
                modifier = modifier,
            )
        },
        status = { modifier ->
            StationStatus(
                size = size,
                station = station,
                modifier = modifier,
            )
        },
        content = { modifier ->
            StationInfo(
                station = station,
                modifier = modifier,
            )
        },
        size = size,
        modifier = modifier,
    )
}

@Composable
private fun StationImage(
    station: SpaceStationDisplayModel,
    modifier: Modifier,
) {
    ImageWrapper(
        image = station.image,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .placeholder(station.isPlaceholder)
            .sharedElement(
                key = "stationImage-${station.id}",
            ),
    )
}

@Composable
private fun StationStatus(
    size: ImageContentCard.Size,
    station: SpaceStationDisplayModel,
    modifier: Modifier,
) {
    val placeholderColor = if (size == ImageContentCard.Size.Compact) {
        PlaceholderDefaults.color(
            contentAlpha = 0.15F,
        )
    } else {
        PlaceholderDefaults.color()
    }

    Pill(
        text = station.status.label,
        containerColor = station.status.containerColor,
        contentColor = station.status.contentColor,
        modifier = modifier
            .placeholder(
                visible = station.isPlaceholder,
                shape = CircleShape,
                color = placeholderColor,
            )
            .sharedElement(
                key = "StationStatus-${station.id}",
            ),
    )
}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
private fun StationInfo(
    station: SpaceStationDisplayModel,
    modifier: Modifier,
) {
    Text(
        text = station.name,
        style = MaterialTheme.typography.titleSmall,
        modifier = modifier
            .placeholder(station.isPlaceholder)
            .sharedBounds("STATION_TITLE_${station.id}"),
    )
}
