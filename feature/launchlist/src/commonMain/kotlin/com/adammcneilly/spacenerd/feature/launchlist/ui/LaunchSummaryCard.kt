package com.adammcneilly.spacenerd.feature.launchlist.ui

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
import com.adammcneilly.spacenerd.core.designsystem.components.ImageContentCard
import com.adammcneilly.spacenerd.core.designsystem.components.ImageWrapper
import com.adammcneilly.spacenerd.core.designsystem.components.Pill
import com.adammcneilly.spacenerd.core.designsystem.utils.currentWindowWidthSizeClass
import com.adammcneilly.spacenerd.core.designsystem.utils.sharedBounds
import com.adammcneilly.spacenerd.core.designsystem.utils.sharedElement
import com.adammcneilly.spacenerd.core.displaymodels.LaunchDisplayModel
import com.eygraber.compose.placeholder.PlaceholderDefaults
import com.eygraber.compose.placeholder.material3.color
import com.eygraber.compose.placeholder.material3.placeholder
import com.eygraber.compose.placeholder.placeholder

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun LaunchSummaryCard(
    launch: LaunchDisplayModel,
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
            LaunchImage(
                launch = launch,
                modifier = modifier,
            )
        },
        status = { modifier ->
            LaunchStatus(
                size = size,
                launch = launch,
                modifier = modifier,
            )
        },
        content = { modifier ->
            LaunchInfo(
                launch = launch,
                modifier = modifier,
            )
        },
        size = size,
        modifier = modifier,
    )
}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
private fun LaunchInfo(
    launch: LaunchDisplayModel,
    modifier: Modifier,
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
private fun LaunchStatus(
    size: ImageContentCard.Size,
    launch: LaunchDisplayModel,
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
        text = launch.status.label,
        containerColor = launch.status.containerColor,
        contentColor = launch.status.contentColor,
        modifier = modifier
            .placeholder(
                visible = launch.isPlaceholder,
                shape = CircleShape,
                color = placeholderColor,
            )
            .sharedElement(
                key = "LaunchStatus-${launch.id}",
            ),
    )
}

@Composable
private fun LaunchImage(
    launch: LaunchDisplayModel,
    modifier: Modifier,
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
