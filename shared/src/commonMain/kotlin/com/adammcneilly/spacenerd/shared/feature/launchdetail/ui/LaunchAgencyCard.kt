package com.adammcneilly.spacenerd.shared.feature.launchdetail.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.adammcneilly.spacenerd.shared.core.displaymodels.AgencyDisplayModel
import com.eygraber.compose.placeholder.material3.placeholder

@Composable
fun LaunchAgencyCard(
    agency: AgencyDisplayModel,
    modifier: Modifier = Modifier,
) {
    ElevatedCard(
        modifier = modifier,
    ) {
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

@Composable
private fun AgencyName(
    agency: AgencyDisplayModel,
) {
    Text(
        text = agency.name,
        style = MaterialTheme.typography.titleMedium,
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
