package com.adammcneilly.spacenerd.feature.news.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.adammcneilly.spacenerd.core.designsystem.components.ImageContentCard
import com.adammcneilly.spacenerd.core.designsystem.components.ImageWrapper
import com.adammcneilly.spacenerd.core.displaymodels.ArticleDisplayModel
import com.eygraber.compose.placeholder.material3.placeholder

@Composable
fun ArticleSummaryCard(
    size: ImageContentCard.Size,
    article: ArticleDisplayModel,
    modifier: Modifier = Modifier,
) {
    ImageContentCard(
        image = { modifier ->
            ImageWrapper(
                image = article.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .placeholder(
                        visible = article.isPlaceholder,
                    ),
            )
        },
        status = { },
        content = { modifier ->
            Column(
                modifier = modifier,
            ) {
                Text(
                    text = article.title,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier
                        .placeholder(
                            visible = article.isPlaceholder,
                        ),
                )

                Text(
                    text = article.publishedAt,
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                        .placeholder(
                            visible = article.isPlaceholder,
                        ),
                )

                Text(
                    text = article.summary,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .padding(top = 4.dp)
                        .placeholder(article.isPlaceholder),
                )
            }
        },
        size = size,
        modifier = modifier,
    )
}
