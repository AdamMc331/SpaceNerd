package com.adammcneilly.spacenerd.feature.launchdetail.ui

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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.adammcneilly.spacenerd.core.designsystem.components.ImageWrapper
import com.adammcneilly.spacenerd.core.displaymodels.RocketDisplayModel
import com.eygraber.compose.placeholder.material3.placeholder

private const val IMAGE_ASPECT_RATIO = 2F

@Composable
fun LaunchRocketCard(
    rocket: RocketDisplayModel,
    modifier: Modifier = Modifier,
) {
    ElevatedCard(
        modifier = modifier,
    ) {
        Column {
            RocketImage(rocket)

            Column(
                modifier = Modifier
                    .padding(16.dp),
            ) {
                RocketName(rocket)

                RocketDescription(
                    rocket = rocket,
                    modifier = Modifier
                        .padding(top = 4.dp),
                )
            }
        }
    }
}

@Composable
private fun RocketImage(
    rocket: RocketDisplayModel,
) {
    ImageWrapper(
        image = rocket.image,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .placeholder(rocket.placeholder)
            .fillMaxWidth()
            .aspectRatio(IMAGE_ASPECT_RATIO),
    )
}

@Composable
private fun RocketName(
    rocket: RocketDisplayModel,
) {
    Text(
        text = rocket.name,
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier
            .placeholder(rocket.placeholder),
    )
}

@Composable
private fun RocketDescription(
    rocket: RocketDisplayModel,
    modifier: Modifier = Modifier,
) {
    Text(
        text = rocket.description,
        maxLines = 3,
        overflow = TextOverflow.Ellipsis,
        modifier = modifier
            .placeholder(rocket.placeholder),
    )
}
