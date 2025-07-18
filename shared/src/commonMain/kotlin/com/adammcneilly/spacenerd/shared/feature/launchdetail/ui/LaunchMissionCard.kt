package com.adammcneilly.spacenerd.shared.feature.launchdetail.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.adammcneilly.spacenerd.core.designsystem.components.ImageWrapper
import com.adammcneilly.spacenerd.core.displaymodels.MissionDisplayModel
import com.eygraber.compose.placeholder.material3.placeholder

private const val LOGO_ASPECT_RATIO = 4F

@Composable
fun LaunchMissionCard(
    mission: MissionDisplayModel,
    modifier: Modifier = Modifier,
) {
    ElevatedCard(
        modifier = modifier,
    ) {
        Column {
            MissionImage(mission)

            Column(
                modifier = Modifier
                    .padding(16.dp),
            ) {
                MissionName(mission)

                MissionDescription(
                    mission = mission,
                    modifier = Modifier
                        .padding(top = 4.dp),
                )
            }
        }
    }
}

@Composable
private fun MissionImage(
    mission: MissionDisplayModel,
) {
    ImageWrapper(
        image = mission.image,
        contentDescription = null,
        modifier = Modifier
            .placeholder(mission.isPlaceholder)
            .fillMaxWidth()
            .aspectRatio(LOGO_ASPECT_RATIO),
    )
}

@Composable
private fun MissionName(
    mission: MissionDisplayModel,
) {
    Text(
        text = mission.name,
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier
            .placeholder(mission.isPlaceholder),
    )
}

@Composable
private fun MissionDescription(
    mission: MissionDisplayModel,
    modifier: Modifier = Modifier,
) {
    Text(
        text = mission.description,
        maxLines = 3,
        overflow = TextOverflow.Ellipsis,
        modifier = modifier
            .placeholder(mission.isPlaceholder),
    )
}
