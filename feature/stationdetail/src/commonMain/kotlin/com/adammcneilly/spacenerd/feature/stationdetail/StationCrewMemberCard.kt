package com.adammcneilly.spacenerd.feature.stationdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.adammcneilly.spacenerd.core.designsystem.components.ImageWrapper
import com.adammcneilly.spacenerd.core.displaymodels.CrewMemberDisplayModel
import com.eygraber.compose.placeholder.material3.placeholder

private val CARD_HEIGHT = 128.dp

@Composable
fun StationCrewMemberCard(
    crewMember: CrewMemberDisplayModel,
    modifier: Modifier = Modifier,
) {
    Card(
        shape = MaterialTheme.shapes.large,
        modifier = modifier
            .height(CARD_HEIGHT),
    ) {
        Row {
            CrewMemberImage(crewMember)

            CrewMemberInfo(crewMember)
        }
    }
}

@Composable
private fun CrewMemberInfo(
    crewMember: CrewMemberDisplayModel,
) {
    Column(
        modifier = Modifier
            .padding(16.dp),
    ) {
        Text(
            text = crewMember.astronaut.name,
            style = MaterialTheme.typography.titleMedium,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .placeholder(crewMember.placeholder),
        )

        Text(
            text = crewMember.role.name,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .padding(top = 4.dp)
                .placeholder(crewMember.placeholder),
        )
    }
}

@Composable
private fun CrewMemberImage(
    crewMember: CrewMemberDisplayModel,
) {
    ImageWrapper(
        image = crewMember.astronaut.image,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .placeholder(
                visible = crewMember.placeholder,
            )
            .fillMaxHeight()
            .aspectRatio(1F),
    )
}
