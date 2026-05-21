package com.adammcneilly.spacenerd.feature.astronautlist.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adammcneilly.spacenerd.core.designsystem.theme.SpaceTheme

private const val SEARCH_SHEET_RATIO = 0.9F

@Composable
fun AstronautListSearchContent(
    state: AstronautListSearchUiState,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth()
            .fillMaxHeight(SEARCH_SHEET_RATIO)
            .padding(16.dp),
    ) {
        InSpaceCheckbox(state)
    }
}

@Composable
private fun InSpaceCheckbox(
    state: AstronautListSearchUiState,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        TriStateCheckbox(
            state = state.inSpace.toToggleableState(),
            onClick = {
            },
        )

        Text(
            text = "In Space",
            style = MaterialTheme.typography.bodyLarge,
        )
    }
}

private fun Boolean?.toToggleableState(): ToggleableState {
    return when (this) {
        true -> ToggleableState.On
        false -> ToggleableState.Off
        null -> ToggleableState.Indeterminate
    }
}

@Preview
@Composable
private fun AstronautListSearchContentPreview() {
    SpaceTheme {
        AstronautListSearchContent(
            state = AstronautListSearchUiState.default(),
        )
    }
}
