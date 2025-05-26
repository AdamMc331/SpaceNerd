package com.adammcneilly.spacenerd.screens.news

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.adammcneilly.spacenerd.core.ui.utils.plus

@Composable
fun NewsContent(
    state: NewsState,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        contentPadding = contentPadding.plus(PaddingValues(16.dp)),
        modifier = modifier,
    ) {
        items(state.articles) { article ->
            Text(
                text = article.title,
            )
        }
    }
}
