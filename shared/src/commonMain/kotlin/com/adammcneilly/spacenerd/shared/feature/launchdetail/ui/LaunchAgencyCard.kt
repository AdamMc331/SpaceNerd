package com.adammcneilly.spacenerd.shared.feature.launchdetail.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.adammcneilly.spacenerd.shared.core.displaymodels.AgencyDisplayModel

@Composable
fun LaunchAgencyCard(
    agency: AgencyDisplayModel,
    modifier: Modifier = Modifier,
) {
    ElevatedCard(
        modifier = modifier,
    ) {
        Column {
            Text(
                text = agency.name,
            )

            Text(
                text = agency.description,
            )
        }
    }
}
