package com.adammcneilly.spacenerd.screens.launches

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.adammcneilly.spacenerd.core.ui.utils.plus
import com.adammcneilly.spacenerd.scaffold.R as scaffoldR

@Composable
fun LaunchListContent(
    state: LaunchListState,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        contentPadding = contentPadding.plus(PaddingValues(16.dp)),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier,
    ) {
        item {
            Text(
                text = stringResource(scaffoldR.string.launches),
                style = MaterialTheme.typography.titleLarge,
            )
        }

        items(state.launches) { launch ->
            LaunchSummaryCard(
                launch = launch,
            )
        }
    }
}
