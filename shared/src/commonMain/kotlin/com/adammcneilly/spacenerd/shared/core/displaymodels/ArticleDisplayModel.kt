package com.adammcneilly.spacenerd.shared.core.displaymodels

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import com.adammcneilly.spacenerd.shared.core.models.Article
import com.adammcneilly.spacenerd.shared.core.models.Author
import kotlinx.datetime.format
import kotlinx.datetime.format.DateTimeComponents
import kotlinx.datetime.format.MonthNames
import kotlinx.datetime.format.char
import kotlin.time.ExperimentalTime

private val publishedDateFormat = DateTimeComponents.Format {
    monthName(MonthNames.ENGLISH_FULL)
    char(' ')
    day()
    char(',')
    char(' ')
    year()
}

data class ArticleDisplayModel(
    val id: String,
    val title: AnnotatedString,
    val publishedAt: String,
    val image: ImageDisplayModel,
    val url: String,
    val summary: String,
    val isPlaceholder: Boolean = false,
) {
    @OptIn(ExperimentalTime::class)
    constructor(
        article: Article,
    ) : this(
        id = article.id,
        title = buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append(article.title)
            }
            append(" | ")

            val authorNames = article.authors.joinToString(transform = Author::name)
            append(authorNames)
        },
        publishedAt = article.publishedAtUtc.format(publishedDateFormat),
        image = ImageDisplayModel.Remote(article.imageUrl),
        url = article.url,
        summary = article.summary,
    )

    companion object {
        fun placeholder(): ArticleDisplayModel {
            return ArticleDisplayModel(
                id = "",
                title = AnnotatedString("Placeholder Title Should Be Long"),
                image = ImageDisplayModel.Placeholder,
                publishedAt = "Month 00, 0000",
                url = "",
                summary = "Placeholder Summary\nMultiline",
                isPlaceholder = true,
            )
        }
    }
}
