package com.adammcneilly.spacenerd.shared.feature.launchdetail.ui

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.adammcneilly.spacenerd.shared.core.displaymodels.LaunchDisplayModel
import com.adammcneilly.spacenerd.shared.ui.components.ImageWrapper
import com.adammcneilly.spacenerd.shared.ui.components.Pill
import com.adammcneilly.spacenerd.shared.ui.utils.sharedBounds
import com.adammcneilly.spacenerd.shared.ui.utils.sharedElement
import com.eygraber.compose.placeholder.PlaceholderDefaults
import com.eygraber.compose.placeholder.material3.color
import com.eygraber.compose.placeholder.material3.placeholder
import com.eygraber.compose.placeholder.placeholder

private const val LAUNCH_IMAGE_ASPECT_RATIO = 1.5F

@Composable
fun LaunchDetailContent(
    state: LaunchDetailUiState,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier,
    ) {
        item {
            LaunchImageStatus(state)
        }

        item {
            LaunchTitle(state)
        }

        item {
            LaunchSubtitle(state)
        }

        if (state.launch.agency != null) {
            item {
                LaunchAgencyCard(
                    agency = state.launch.agency,
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth()
                        .padding(
                            horizontal = 16.dp,
                        ),
                )
            }
        }
    }
}

@Composable
@OptIn(ExperimentalSharedTransitionApi::class)
private fun LaunchTitle(
    state: LaunchDetailUiState,
) {
    Text(
        text = state.launch.name,
        style = MaterialTheme.typography.titleLarge,
        modifier = Modifier
            .padding(top = 16.dp)
            .padding(horizontal = 16.dp)
            .placeholder(state.launch.isPlaceholder)
            .sharedBounds("LAUNCH_TITLE_${state.launch.id}"),
    )
}

@Composable
@OptIn(ExperimentalSharedTransitionApi::class)
private fun LaunchSubtitle(
    state: LaunchDetailUiState,
) {
    Text(
        text = state.launch.subtitle,
        style = MaterialTheme.typography.bodySmall,
        modifier = Modifier
            .padding(top = 4.dp)
            .padding(horizontal = 16.dp)
            .placeholder(state.launch.isPlaceholder)
            .sharedBounds("LAUNCH_SUBTITLE_${state.launch.id}"),
    )
}

@Composable
private fun LaunchImageStatus(
    state: LaunchDetailUiState,
) {
    Box {
        LaunchImage(
            launch = state.launch,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(LAUNCH_IMAGE_ASPECT_RATIO)
                .sharedElement(
                    key = "LaunchImage-${state.launch.id}",
                ),
        )

        LaunchStatus(
            launch = state.launch,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .statusBarsPadding()
                .padding(16.dp)
                .placeholder(
                    visible = state.launch.isPlaceholder,
                    color = PlaceholderDefaults.color(
                        contentAlpha = 0.15F,
                    ),
                    shape = CircleShape,
                )
                .sharedElement(
                    key = "LaunchStatus-${state.launch.id}",
                ),
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
            .placeholder(launch.isPlaceholder),
    )
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
        modifier = modifier,
    )
}
