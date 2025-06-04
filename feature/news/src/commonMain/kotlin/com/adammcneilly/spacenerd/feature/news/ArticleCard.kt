package com.adammcneilly.spacenerd.feature.news

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.adammcneilly.spacenerd.core.displaymodels.ArticleDisplayModel
import com.adammcneilly.spacenerd.core.ui.components.ImageWrapper
import com.eygraber.compose.placeholder.material3.placeholder

private const val ARTICLE_IMAGE_ASPECT_RATIO = 1.5F

@Composable
fun ArticleCard(
    article: ArticleDisplayModel,
    modifier: Modifier = Modifier,
) {
    // TODO: Need adaptive info for CMP format
    @Suppress("ForbiddenComment")
    val isAtLeastMediumWidth = false

    if (isAtLeastMediumWidth) {
        MediumExpandedCard(article, modifier)
    } else {
        CompactCard(article, modifier)
    }
}

@Composable
private fun MediumExpandedCard(
    article: ArticleDisplayModel,
    modifier: Modifier = Modifier,
) {
    ElevatedCard(
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
            .fillMaxWidth(),
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .padding(16.dp),
        ) {
            ImageWrapper(
                image = article.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .placeholder(
                        visible = article.isPlaceholder,
                    )
                    .size(64.dp)
                    .clip(MaterialTheme.shapes.medium),
            )

            ArticleInfo(article)
        }
    }
}

@Composable
private fun CompactCard(
    article: ArticleDisplayModel,
    modifier: Modifier = Modifier,
) {
    ElevatedCard(
        shape = MaterialTheme.shapes.large,
        modifier = modifier,
    ) {
        Column {
            ImageWrapper(
                image = article.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .placeholder(
                        visible = article.isPlaceholder,
                    )
                    .fillMaxWidth()
                    .aspectRatio(ARTICLE_IMAGE_ASPECT_RATIO),
            )

            ArticleInfo(
                article = article,
                modifier = Modifier
                    .padding(16.dp),
            )
        }
    }
}

@Composable
private fun ArticleInfo(
    article: ArticleDisplayModel,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = article.titleAuthor,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
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
}
