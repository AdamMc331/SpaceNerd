package com.adammcneilly.spacenerd.feature.news.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.PersonOutline
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.adammcneilly.spacenerd.core.designsystem.components.ImageContentCard
import com.adammcneilly.spacenerd.core.designsystem.components.ImageWrapper
import com.adammcneilly.spacenerd.core.designsystem.components.InlineIconText
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
            ArticleImage(
                article = article,
                modifier = modifier,
            )
        },
        status = { },
        content = { modifier ->
            ArticleInfo(
                article = article,
                modifier = modifier,
            )
        },
        size = size,
        modifier = modifier,
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun ArticleInfo(
    article: ArticleDisplayModel,
    modifier: Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = article.title,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .placeholder(
                    visible = article.isPlaceholder,
                ),
        )

        Text(
            text = article.summary,
            style = MaterialTheme.typography.bodySmall,
            maxLines = 5,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(top = 4.dp)
                .placeholder(article.isPlaceholder),
        )

        HorizontalDivider(
            modifier = Modifier
                .padding(vertical = 16.dp),
        )

        FlowRow(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            InlineIconText(
                text = article.author,
                icon = Icons.Default.PersonOutline,
                leadingIcon = true,
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier
                    .placeholder(
                        visible = article.isPlaceholder,
                    ),
            )

            InlineIconText(
                text = article.publishedAt,
                icon = Icons.Default.History,
                leadingIcon = true,
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier
                    .placeholder(
                        visible = article.isPlaceholder,
                    ),
            )
        }
    }
}

@Composable
private fun ArticleImage(
    article: ArticleDisplayModel,
    modifier: Modifier,
) {
    ImageWrapper(
        image = article.image,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .placeholder(
                visible = article.isPlaceholder,
            ),
    )
}
