package com.adammcneilly.spacenerd.feature.news.ui

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
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import com.adammcneilly.spacenerd.core.designsystem.components.ImageContentCard
import com.adammcneilly.spacenerd.core.designsystem.components.ImageContentCardConfig
import com.adammcneilly.spacenerd.core.designsystem.components.ImageContentCardSize
import com.adammcneilly.spacenerd.core.designsystem.components.ImageWrapper
import com.adammcneilly.spacenerd.core.displaymodels.ArticleDisplayModel
import com.eygraber.compose.placeholder.material3.placeholder

private const val ARTICLE_IMAGE_ASPECT_RATIO = 1.5F

enum class ArticleSummaryCardVariant {
    Compact,
    Expanded,
}

@Composable
fun ArticleSummaryCard(
    size: ImageContentCardSize,
    article: ArticleDisplayModel,
    modifier: Modifier = Modifier,
) {
    val config = ImageContentCardConfig(
        image = article.image,
        title = article.title,
        subtitle = AnnotatedString(article.summary),
        placeholder = article.isPlaceholder,
        transitionKeyPrefix = "Article-${article.id}",
        status = null,
        size = size,
    )

    ImageContentCard(
        config,
        modifier = modifier,
    )
}
