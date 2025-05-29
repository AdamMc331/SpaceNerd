package com.adammcneilly.spacenerd.screens.launches

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.adammcneilly.spacenerd.core.displaymodels.LaunchDisplayModel
import com.adammcneilly.spacenerd.core.ui.utils.plus
import com.adammcneilly.spacenerd.data.DataResult
import com.adammcneilly.spacenerd.scaffold.R as scaffoldR

@Composable
fun LaunchListContent(
    state: LaunchListState,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier,
) {
    when (state.launches) {
        is DataResult.Error -> {
            ErrorMessage(
                message = state.launches.error.message,
                modifier = modifier
                    .fillMaxSize()
                    .padding(contentPadding),
            )
        }
        DataResult.Loading -> {
            LoadingScreen(
                modifier = modifier
                    .fillMaxSize()
                    .padding(contentPadding),
            )
        }
        is DataResult.Success<List<LaunchDisplayModel>> -> {
            LaunchList(
                contentPadding = contentPadding,
                launches = state.launches.data,
                modifier = Modifier
                    .fillMaxSize(),
            )
        }
    }
}

@Composable
private fun LoadingScreen(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier,
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.Center),
        )
    }
}

@Composable
private fun ErrorMessage(
    message: String?,
    modifier: Modifier = Modifier,
) {
    Text(
        text = message.orEmpty(),
        modifier = modifier,
    )
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun LaunchList(
    contentPadding: PaddingValues,
    launches: List<LaunchDisplayModel>,
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

        items(launches) { launch ->
            LaunchSummaryCard(
                launch = launch,
            )
        }
    }
}
