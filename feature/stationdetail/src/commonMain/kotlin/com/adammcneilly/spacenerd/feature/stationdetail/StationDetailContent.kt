package com.adammcneilly.spacenerd.feature.stationdetail

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun StationDetailContent(
    state: StationDetailUiState,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier,
) {
    Text(
        text = "Station Detail Stub: ${state.station}",
        modifier = modifier
            .padding(contentPadding),
    )
}
