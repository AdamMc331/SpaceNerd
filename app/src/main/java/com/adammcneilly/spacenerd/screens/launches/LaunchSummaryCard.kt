package com.adammcneilly.spacenerd.screens.launches

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.datasource.CollectionPreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.adammcneilly.spacenerd.R
import com.adammcneilly.spacenerd.core.displaymodels.ImageDisplayModel
import com.adammcneilly.spacenerd.core.displaymodels.LaunchDisplayModel
import com.adammcneilly.spacenerd.core.displaymodels.LaunchStatusDisplayModel
import com.adammcneilly.spacenerd.core.models.LaunchStatus
import com.adammcneilly.spacenerd.core.ui.components.ImageWrapper
import com.adammcneilly.spacenerd.core.ui.components.Pill
import com.adammcneilly.spacenerd.scaffold.ui.theme.SpaceTheme
import com.eygraber.compose.placeholder.PlaceholderDefaults
import com.eygraber.compose.placeholder.material3.color
import com.eygraber.compose.placeholder.material3.placeholder

private const val CARD_IMAGE_ASPECT_RATIO = 1.5F

@Composable
fun LaunchSummaryCard(
    launch: LaunchDisplayModel,
    modifier: Modifier = Modifier,
) {
    ElevatedCard(
        shape = MaterialTheme.shapes.large,
        modifier = modifier,
    ) {
        Column {
            Box {
                LaunchImage(launch)

                Pill(
                    text = launch.status.label,
                    containerColor = launch.status.containerColor,
                    contentColor = launch.status.contentColor,
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

            LaunchInfo(launch)
        }
    }
}

@Composable
private fun LaunchInfo(
    launch: LaunchDisplayModel,
) {
    Column(
        modifier = Modifier
            .padding(16.dp),
    ) {
        Text(
            text = launch.name,
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier
                .placeholder(launch.isPlaceholder),
        )

        Text(
            text = launch.subtitle,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .padding(top = 4.dp)
                .placeholder(launch.isPlaceholder),
        )
    }
}

@Composable
private fun LaunchImage(
    launch: LaunchDisplayModel,
) {
    ImageWrapper(
        image = launch.image,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(CARD_IMAGE_ASPECT_RATIO)
            .placeholder(launch.isPlaceholder),
    )
}

private class LaunchDisplayModelProvider :
    CollectionPreviewParameterProvider<LaunchDisplayModel>(
        collection = listOf(
            LaunchDisplayModel.placeholder(),
            LaunchDisplayModel(
                id = "123",
                name = "Falcon 9 Block 5 | Starlink Group 12-19",
                image = ImageDisplayModel.Local(R.drawable.armstrong),
                status = LaunchStatusDisplayModel(LaunchStatus.Go),
                subtitle = "SpaceX • Cape Canaveral SFS, FL, USA",
            ),
        ),
    )

@Composable
@PreviewLightDark
@PreviewFontScale
@PreviewDynamicColors
private fun LaunchSummaryCardPreview(
    @PreviewParameter(LaunchDisplayModelProvider::class) launch: LaunchDisplayModel,
) {
    SpaceTheme {
        LaunchSummaryCard(
            launch = launch,
        )
    }
}
