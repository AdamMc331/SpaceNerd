package com.adammcneilly.spacenerd.feature.astronautdetail

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AstronautDetailContent(
    state: AstronautDetailUiState,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier,
) {
    Text(
        text = "Stub screen: $state",
        modifier = modifier
            .padding(contentPadding),
    )
}
