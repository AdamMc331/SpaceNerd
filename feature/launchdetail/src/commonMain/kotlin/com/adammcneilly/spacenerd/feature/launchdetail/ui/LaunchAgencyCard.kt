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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.adammcneilly.spacenerd.core.designsystem.components.ImageWrapper
import com.adammcneilly.spacenerd.core.displaymodels.AgencyDisplayModel
import com.eygraber.compose.placeholder.material3.placeholder

private const val LOGO_ASPECT_RATIO = 4F

@Composable
fun LaunchAgencyCard(
    agency: AgencyDisplayModel,
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
        Column {
            AgencyImage(agency)

            Column(
                modifier = Modifier
                    .padding(16.dp),
            ) {
                AgencyName(agency)

                AgencyDescription(
                    agency = agency,
                    modifier = Modifier
                        .padding(top = 4.dp),
                )
            }
        }
    }
}

@Composable
private fun AgencyImage(
    agency: AgencyDisplayModel,
) {
    ImageWrapper(
        image = agency.logo,
        contentDescription = null,
        modifier = Modifier
            .placeholder(agency.isPlaceholder)
            .fillMaxWidth()
            .aspectRatio(LOGO_ASPECT_RATIO),
    )
}

@Composable
private fun AgencyName(
    agency: AgencyDisplayModel,
) {
    Text(
        text = agency.name,
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .placeholder(agency.isPlaceholder),
    )
}

@Composable
private fun AgencyDescription(
    agency: AgencyDisplayModel,
    modifier: Modifier = Modifier,
) {
    Text(
        text = agency.description,
        maxLines = 3,
        overflow = TextOverflow.Ellipsis,
        modifier = modifier
            .placeholder(agency.isPlaceholder),
    )
}
