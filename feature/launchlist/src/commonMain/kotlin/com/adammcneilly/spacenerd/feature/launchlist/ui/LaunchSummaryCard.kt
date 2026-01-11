package com.adammcneilly.spacenerd.feature.launchlist.ui

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CorporateFare
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.PinDrop
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.window.core.layout.WindowSizeClass
import com.adammcneilly.spacenerd.core.designsystem.components.ImageContentCard
import com.adammcneilly.spacenerd.core.designsystem.components.ImageWrapper
import com.adammcneilly.spacenerd.core.designsystem.components.InlineIconText
import com.adammcneilly.spacenerd.core.designsystem.components.Pill
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
    val isAtLeastMediumWidth = currentWindowAdaptiveInfo().windowSizeClass.isWidthAtLeastBreakpoint(
        WindowSizeClass.WIDTH_DP_MEDIUM_LOWER_BOUND,
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
                .placeholder(launch.isPlaceholder),
        )

        Text(
            text = launch.mission?.description.orEmpty(),
            style = MaterialTheme.typography.bodySmall,
            maxLines = 5,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(top = 4.dp)
                .placeholder(launch.isPlaceholder),
        )

        HorizontalDivider(
            modifier = Modifier
                .padding(vertical = 16.dp),
        )

        InlineIconText(
            text = launch.agency?.name.orEmpty(),
            icon = Icons.Default.CorporateFare,
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier
                .placeholder(launch.isPlaceholder),
        )

        InlineIconText(
            text = launch.launchPad?.location.orEmpty(),
            icon = Icons.Default.PinDrop,
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier
                .padding(top = 8.dp)
                .placeholder(launch.isPlaceholder),
        )

        InlineIconText(
            text = launch.launchTime,
            icon = Icons.Default.History,
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier
                .padding(top = 8.dp)
                .placeholder(launch.isPlaceholder),
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
            .placeholder(launch.isPlaceholder),
    )
}
