package com.adammcneilly.spacenerd.screens.launches

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.adammcneilly.spacenerd.core.displaymodels.LaunchDisplayModel
import com.adammcneilly.spacenerd.core.ui.components.ImageWrapper

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
            LaunchImage(launch)

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
            .aspectRatio(CARD_IMAGE_ASPECT_RATIO),
    )
}
