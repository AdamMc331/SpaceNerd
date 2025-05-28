package com.adammcneilly.spacenerd.screens.news

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.adammcneilly.spacenerd.core.displaymodels.ArticleDisplayModel
import com.adammcneilly.spacenerd.core.ui.components.ImageWrapper

private const val ARTICLE_IMAGE_ASPECT_RATIO = 1.5F

@Composable
fun ArticleCard(
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
                    .fillMaxWidth()
                    .aspectRatio(ARTICLE_IMAGE_ASPECT_RATIO),
            )

            Column(
                modifier = Modifier
                    .padding(16.dp),
            ) {
                Text(
                    text = article.titleAuthor,
                    style = MaterialTheme.typography.titleMedium,
                )

                Spacer(
                    modifier = Modifier
                        .height(4.dp),
                )

                Text(
                    text = article.summary,
                    style = MaterialTheme.typography.bodySmall,
                )
            }
        }
    }
}
