package com.adammcneilly.spacenerd.feature.astronautdetail

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.adammcneilly.spacenerd.core.designsystem.components.ImageWrapper
import com.adammcneilly.spacenerd.core.designsystem.utils.sharedBounds
import com.adammcneilly.spacenerd.core.designsystem.utils.sharedElement
import com.eygraber.compose.placeholder.material3.placeholder

private const val ASTRONAUT_IMAGE_ASPECT_RATIO = 1F

@Composable
fun AstronautDetailContent(
    state: AstronautDetailUiState,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        contentPadding = PaddingValues(
            bottom = 16.dp + contentPadding.calculateBottomPadding(),
        ),
        modifier = modifier,
    ) {
        item {
            AstronautImage(state = state)
        }

        item {
            AstronautName(state)
        }

        item {
            AstronautBio(state)
        }
    }
}

@Composable
@OptIn(ExperimentalSharedTransitionApi::class)
private fun AstronautName(
    state: AstronautDetailUiState,
) {
    Text(
        text = state.astronaut.name,
        style = MaterialTheme.typography.titleLarge,
        modifier = Modifier
            .padding(top = 16.dp)
            .padding(horizontal = 16.dp)
            .placeholder(state.astronaut.placeholder)
            .sharedBounds(
                key = state.astronaut.nameSharedElementKey,
            ),
    )
}

@Composable
private fun AstronautBio(
    state: AstronautDetailUiState,
) {
    Text(
        text = state.astronaut.bio,
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier
            .padding(top = 8.dp)
            .padding(horizontal = 16.dp)
            .placeholder(state.astronaut.placeholder),
    )
}

@Composable
private fun AstronautImage(
    state: AstronautDetailUiState,
) {
    ImageWrapper(
        image = state.astronaut.image,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(ASTRONAUT_IMAGE_ASPECT_RATIO)
            .sharedElement(
                key = state.astronaut.imageSharedElementKey,
            )
            .placeholder(state.astronaut.placeholder),
    )
}
