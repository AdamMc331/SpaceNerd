package com.adammcneilly.spacenerd.feature.launchdetail.ui

import androidx.compose.foundation.border
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

@Composable
fun LaunchMissionCard(
    mission: MissionDisplayModel,
    modifier: Modifier = Modifier,
) {
    ElevatedCard(
        modifier = modifier
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outlineVariant,
                shape = MaterialTheme.shapes.medium,
            ),
    ) {
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
        modifier = modifier
            .placeholder(mission.isPlaceholder),
    )
}
