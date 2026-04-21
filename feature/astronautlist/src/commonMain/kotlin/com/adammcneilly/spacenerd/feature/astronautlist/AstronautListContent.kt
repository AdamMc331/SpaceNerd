package com.adammcneilly.spacenerd.feature.astronautlist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AstronautListContent(
    state: AstronautListUiState,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp),
        modifier = modifier,
    ) {
        item {
            Text(
                text = "Astronauts",
                style = MaterialTheme.typography.titleLarge,
            )
        }

        items(state.astronauts) { astronaut ->
            AstronautCard(
                astronaut = astronaut,
            )
        }
    }
}
