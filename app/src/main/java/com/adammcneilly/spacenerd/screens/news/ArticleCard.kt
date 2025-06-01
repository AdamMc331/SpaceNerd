package com.adammcneilly.spacenerd.screens.news

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.datasource.CollectionPreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.adammcneilly.spacenerd.R
import com.adammcneilly.spacenerd.core.displaymodels.ArticleDisplayModel
import com.adammcneilly.spacenerd.core.displaymodels.AuthorDisplayModel
import com.adammcneilly.spacenerd.core.displaymodels.ImageDisplayModel
import com.adammcneilly.spacenerd.core.ui.components.ImageWrapper
import com.adammcneilly.spacenerd.scaffold.ui.theme.SpaceTheme
import com.eygraber.compose.placeholder.material3.placeholder

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
                    .placeholder(
                        visible = article.isPlaceholder,
                    )
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
    }
}

private class ArticleDisplayModelProvider :
    CollectionPreviewParameterProvider<ArticleDisplayModel>(
        collection = listOf(
            ArticleDisplayModel.placeholder(),
            ArticleDisplayModel(
                id = "123",
                title = "Neil Armstrong Steps Foot On The Moon",
                image = ImageDisplayModel.Local(R.drawable.armstrong),
                url = "",
                summary = "Armstrong, Aldrin, and Collins complete successful Apollo 11 mission.",
                authors = listOf(
                    AuthorDisplayModel(
                        name = "NASA",
                    ),
                ),
            ),
        ),
    )

@Composable
@PreviewLightDark
@PreviewFontScale
@PreviewDynamicColors
private fun ArticleCardPreview(
    @PreviewParameter(ArticleDisplayModelProvider::class) article: ArticleDisplayModel,
) {
    SpaceTheme {
        ArticleCard(
            article = article,
        )
    }
}
