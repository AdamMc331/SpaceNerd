package com.adammcneilly.spacenerd.feature.launchlist.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.adammcneilly.spacenerd.core.designsystem.utils.plus

@Composable
fun LaunchListContent(
    state: LaunchListUiState,
    contentPadding: PaddingValues,
    onEvent: (LaunchListUiEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        contentPadding = contentPadding.plus(PaddingValues(16.dp)),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier,
    ) {
        item {
            Text(
                text = "Launches",
                style = MaterialTheme.typography.titleLarge,
            )
        }

        items(state.launches) { launch ->
            LaunchSummaryCard(
                launch = launch,
                modifier = Modifier
                    .clickable {
                        onEvent.invoke(LaunchListUiEvent.LaunchSelected(launch))
                    },
            )
        }
    }
}
