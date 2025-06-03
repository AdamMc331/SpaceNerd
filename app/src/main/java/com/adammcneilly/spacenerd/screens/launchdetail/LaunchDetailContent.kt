package com.adammcneilly.spacenerd.screens.launchdetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.adammcneilly.spacenerd.core.displaymodels.LaunchDisplayModel
import com.adammcneilly.spacenerd.core.ui.components.ImageWrapper
import com.adammcneilly.spacenerd.core.ui.components.Pill
import com.adammcneilly.spacenerd.core.ui.utils.sharedElement
import com.eygraber.compose.placeholder.PlaceholderDefaults
import com.eygraber.compose.placeholder.material3.color
import com.eygraber.compose.placeholder.material3.placeholder

private const val LAUNCH_IMAGE_ASPECT_RATIO = 1.5F

@Composable
fun LaunchDetailContent(
    state: LaunchDetailState,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier,
    ) {
        item {
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
