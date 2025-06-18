package com.adammcneilly.spacenerd.shared.feature.launchlist.ui

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
import com.adammcneilly.spacenerd.shared.core.displaymodels.LaunchDisplayModel
import com.adammcneilly.spacenerd.shared.ui.components.ImageWrapper
import com.adammcneilly.spacenerd.shared.ui.components.Pill
import com.adammcneilly.spacenerd.shared.ui.utils.currentWindowWidthSizeClass
import com.adammcneilly.spacenerd.shared.ui.utils.sharedBounds
import com.adammcneilly.spacenerd.shared.ui.utils.sharedElement
import com.eygraber.compose.placeholder.PlaceholderDefaults
import com.eygraber.compose.placeholder.material3.color
import com.eygraber.compose.placeholder.material3.placeholder

private const val CARD_IMAGE_ASPECT_RATIO = 1.5F

@Composable
fun LaunchSummaryCard(
    launch: LaunchDisplayModel,
    modifier: Modifier = Modifier,
) {
    val isAtLeastMediumWidth = currentWindowWidthSizeClass() in listOf(
        WindowWidthSizeClass.Medium,
        WindowWidthSizeClass.Expanded,
    )

    if (isAtLeastMediumWidth) {
        MediumExpandedCard(launch, modifier)
    } else {
        CompactCard(launch, modifier)
    }
}

@Composable
private fun MediumExpandedCard(
    launch: LaunchDisplayModel,
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
            LaunchImage(
                launch = launch,
                modifier = Modifier
                    .size(64.dp)
                    .clip(MaterialTheme.shapes.medium),
            )

            Column {
                LaunchInfo(launch)

                LaunchStatus(
                    launch = launch,
                    textStyle = MaterialTheme.typography.labelSmall,
                    modifier = Modifier
                        .padding(top = 4.dp)
                        .placeholder(
                            visible = launch.isPlaceholder,
                            shape = CircleShape,
                        ),
                )
            }
        }
    }
}

@Composable
private fun CompactCard(
    launch: LaunchDisplayModel,
    modifier: Modifier = Modifier,
) {
    ElevatedCard(
        shape = MaterialTheme.shapes.large,
        modifier = modifier,
    ) {
        Column {
            Box {
                LaunchImage(
                    launch = launch,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(CARD_IMAGE_ASPECT_RATIO),
                )

                LaunchStatus(
                    launch = launch,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(16.dp)
                        .placeholder(
                            visible = launch.isPlaceholder,
                            color = PlaceholderDefaults.color(
                                contentAlpha = 0.15F,
                            ),
                            shape = CircleShape,
                        ),
                )
            }

            LaunchInfo(
                launch = launch,
                modifier = Modifier
                    .padding(16.dp),
            )
        }
    }
}

@Composable
private fun LaunchStatus(
    launch: LaunchDisplayModel,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = LocalTextStyle.current,
) {
    Pill(
        text = launch.status.label,
        containerColor = launch.status.containerColor,
        contentColor = launch.status.contentColor,
        textStyle = textStyle,
        modifier = modifier
            .sharedElement(
                key = "LaunchStatus-${launch.id}",
            ),
    )
}

@Composable
@OptIn(ExperimentalSharedTransitionApi::class)
private fun LaunchInfo(
    launch: LaunchDisplayModel,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = launch.name,
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier
                .placeholder(launch.isPlaceholder)
                .sharedBounds("LAUNCH_TITLE_${launch.id}"),
        )

        Text(
            text = launch.subtitle,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .padding(top = 4.dp)
                .placeholder(launch.isPlaceholder)
                .sharedBounds("LAUNCH_SUBTITLE_${launch.id}"),
        )
    }
}

@Composable
private fun LaunchImage(
    launch: LaunchDisplayModel,
    modifier: Modifier = Modifier,
) {
    ImageWrapper(
        image = launch.image,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .placeholder(launch.isPlaceholder)
            .sharedElement(
                key = "LaunchImage-${launch.id}",
            ),
    )
}
