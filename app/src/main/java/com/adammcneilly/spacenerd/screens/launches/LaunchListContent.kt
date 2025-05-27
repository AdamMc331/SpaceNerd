package com.adammcneilly.spacenerd.screens.launches

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.adammcneilly.spacenerd.core.displaymodels.LaunchDisplayModel
import com.adammcneilly.spacenerd.core.ui.utils.plus
import com.adammcneilly.spacenerd.data.DataResult

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
private fun LaunchList(
    contentPadding: PaddingValues,
    launches: List<LaunchDisplayModel>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        contentPadding = contentPadding.plus(PaddingValues(16.dp)),
        modifier = modifier,
    ) {
        itemsIndexed(launches) { index, launch ->
            Text(
                text = launch.name,
            )

            if (index != launches.lastIndex) {
                HorizontalDivider()
            }
        }
    }
}
