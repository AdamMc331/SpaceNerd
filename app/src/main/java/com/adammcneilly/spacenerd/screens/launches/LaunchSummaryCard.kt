package com.adammcneilly.spacenerd.screens.launches

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
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.datasource.CollectionPreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.window.core.layout.WindowSizeClass
import com.adammcneilly.spacenerd.R
import com.adammcneilly.spacenerd.core.displaymodels.ImageDisplayModel
import com.adammcneilly.spacenerd.core.displaymodels.LaunchDisplayModel
import com.adammcneilly.spacenerd.core.displaymodels.LaunchStatusDisplayModel
import com.adammcneilly.spacenerd.core.models.LaunchStatus
import com.adammcneilly.spacenerd.core.ui.components.ImageWrapper
import com.adammcneilly.spacenerd.core.ui.components.Pill
import com.adammcneilly.spacenerd.core.ui.scaffold.theme.SpaceTheme
import com.adammcneilly.spacenerd.core.ui.utils.sharedBounds
import com.adammcneilly.spacenerd.core.ui.utils.sharedElement
import com.eygraber.compose.placeholder.PlaceholderDefaults
import com.eygraber.compose.placeholder.material3.color
import com.eygraber.compose.placeholder.material3.placeholder

private const val CARD_IMAGE_ASPECT_RATIO = 1.5F

@Composable
fun LaunchSummaryCard(
    launch: LaunchDisplayModel,
    modifier: Modifier = Modifier,
) {
    val isAtLeastMediumWidth = currentWindowAdaptiveInfo()
        .windowSizeClass
        .isWidthAtLeastBreakpoint(WindowSizeClass.WIDTH_DP_MEDIUM_LOWER_BOUND)

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

private class LaunchDisplayModelProvider :
    CollectionPreviewParameterProvider<LaunchDisplayModel>(
        collection = listOf(
            LaunchDisplayModel.placeholder(),
            LaunchDisplayModel(
                id = "123",
                name = "Falcon 9 Block 5 | Starlink Group 12-19",
                image = ImageDisplayModel.Local(R.drawable.falcon9),
                status = LaunchStatusDisplayModel(LaunchStatus.Go),
                subtitle = "SpaceX • Cape Canaveral SFS, FL, USA",
            ),
        ),
    )

@Composable
@PreviewLightDark
@Preview(
    device = "spec:width=411dp,height=891dp,orientation=landscape,dpi=420",
)
private fun LaunchSummaryCardPreview(
    @PreviewParameter(LaunchDisplayModelProvider::class) launch: LaunchDisplayModel,
) {
    SpaceTheme {
        LaunchSummaryCard(
            launch = launch,
        )
    }
}
