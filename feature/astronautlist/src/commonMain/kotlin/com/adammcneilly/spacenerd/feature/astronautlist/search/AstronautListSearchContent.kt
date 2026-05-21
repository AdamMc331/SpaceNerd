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
import com.adammcneilly.spacenerd.feature.astronautlist.AstronautListUiEvent

private const val SEARCH_SHEET_RATIO = 0.9F

@Composable
fun AstronautListSearchContent(
    state: AstronautListSearchUiState,
    onEvent: (AstronautListUiEvent.SearchEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.fillMaxWidth()
            .fillMaxHeight(SEARCH_SHEET_RATIO)
            .padding(16.dp),
    ) {
        Text(
            text = "Search Astronauts",
            style = MaterialTheme.typography.titleMedium,
        )

        InSpaceCheckbox(
            state = state,
            onClick = {
                onEvent.invoke(AstronautListUiEvent.SearchEvent.InSpaceClicked)
            },
        )
    }
}

@Composable
private fun InSpaceCheckbox(
    state: AstronautListSearchUiState,
    onClick: () -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        TriStateCheckbox(
            state = state.inSpace,
            onClick = onClick,
        )

        Text(
            text = "In Space",
            style = MaterialTheme.typography.bodyLarge,
        )
    }
}

@Preview
@Composable
private fun AstronautListSearchContentPreview() {
    SpaceTheme {
        AstronautListSearchContent(
            state = AstronautListSearchUiState.default(),
            onEvent = {},
        )
    }
}
