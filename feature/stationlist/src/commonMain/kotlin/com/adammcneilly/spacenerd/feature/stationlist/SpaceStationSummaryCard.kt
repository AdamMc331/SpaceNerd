package com.adammcneilly.spacenerd.feature.stationlist

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.adammcneilly.spacenerd.core.designsystem.components.ImageWrapper
import com.adammcneilly.spacenerd.core.designsystem.components.Pill
import com.adammcneilly.spacenerd.core.designsystem.utils.currentWindowWidthSizeClass
import com.adammcneilly.spacenerd.core.designsystem.utils.sharedBounds
import com.adammcneilly.spacenerd.core.designsystem.utils.sharedElement
import com.adammcneilly.spacenerd.core.displaymodels.SpaceStationDisplayModel
import com.eygraber.compose.placeholder.PlaceholderDefaults
import com.eygraber.compose.placeholder.material3.color
import com.eygraber.compose.placeholder.material3.placeholder

private const val CARD_IMAGE_ASPECT_RATIO = 1.5F

@Composable
fun SpaceStationSummaryCard(
    station: SpaceStationDisplayModel,
    modifier: Modifier = Modifier,
) {
    val isAtLeastMediumWidth = currentWindowWidthSizeClass() in listOf(
        WindowWidthSizeClass.Medium,
        WindowWidthSizeClass.Expanded,
    )

    if (isAtLeastMediumWidth) {
        MediumExpandedCard(station, modifier)
    } else {
        CompactCard(station, modifier)
    }
}

@Composable
private fun MediumExpandedCard(
    station: SpaceStationDisplayModel,
    modifier: Modifier = Modifier,
) {
    ElevatedCard(
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
            .fillMaxWidth(),
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .padding(16.dp),
        ) {
            StationImage(
                station = station,
                modifier = Modifier
                    .size(64.dp)
                    .clip(MaterialTheme.shapes.medium),
            )

            Column {
                StationInfo(station)

                StationStatus(
                    station = station,
                    textStyle = MaterialTheme.typography.labelSmall,
                    modifier = Modifier
                        .padding(top = 4.dp)
                        .placeholder(
                            visible = station.isPlaceholder,
                            shape = CircleShape,
                        ),
                )
            }
        }
    }
}

@Composable
private fun CompactCard(
    station: SpaceStationDisplayModel,
    modifier: Modifier = Modifier,
) {
    ElevatedCard(
        shape = MaterialTheme.shapes.large,
        modifier = modifier,
    ) {
        Column {
            Box {
                StationImage(
                    station = station,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(CARD_IMAGE_ASPECT_RATIO),
                )

                StationStatus(
                    station = station,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(16.dp)
                        .placeholder(
                            visible = station.isPlaceholder,
                            color = PlaceholderDefaults.color(
                                contentAlpha = 0.15F,
                            ),
                            shape = CircleShape,
                        ),
                )
            }

            StationInfo(
                station = station,
                modifier = Modifier
                    .padding(16.dp),
            )
        }
    }
}

@Composable
private fun StationStatus(
    station: SpaceStationDisplayModel,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = LocalTextStyle.current,
) {
    Pill(
        text = station.status.label,
        containerColor = station.status.containerColor,
        contentColor = station.status.contentColor,
        textStyle = textStyle,
        modifier = modifier
            .sharedElement(
                key = "StationStatus-${station.id}",
            ),
    )
}

@Composable
@OptIn(ExperimentalSharedTransitionApi::class)
private fun StationInfo(
    station: SpaceStationDisplayModel,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = station.name,
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier
                .placeholder(station.isPlaceholder)
                .sharedBounds("STATION_TITLE_${station.id}"),
        )

//        Text(
//            text = launch.subtitle,
//            style = MaterialTheme.typography.bodySmall,
//            modifier = Modifier
//                .padding(top = 4.dp)
//                .placeholder(launch.isPlaceholder)
//                .sharedBounds("LAUNCH_SUBTITLE_${launch.id}"),
//        )
    }
}

@Composable
private fun StationImage(
    station: SpaceStationDisplayModel,
    modifier: Modifier = Modifier,
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
