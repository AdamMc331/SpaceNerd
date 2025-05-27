package com.adammcneilly.spacenerd.screens.news

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.adammcneilly.spacenerd.core.displaymodels.ArticleDisplayModel
import com.adammcneilly.spacenerd.core.ui.components.ImageWrapper

@Composable
fun ArticleListItem(
    article: ArticleDisplayModel,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
    ) {
        ImageWrapper(
            image = article.image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(48.dp),
        )

        Column {
            Text(
                text = article.title,
                style = MaterialTheme.typography.titleSmall,
            )

            Text(
                text = article.authorNames,
            )
        }
    }
}
