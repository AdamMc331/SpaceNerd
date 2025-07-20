package com.adammcneilly.spacenerd.core.displaymodels

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import com.adammcneilly.spacenerd.core.designsystem.models.ImageModel
import com.adammcneilly.spacenerd.core.models.Article
import com.adammcneilly.spacenerd.core.models.Author
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

/**
 * A user-friendly representation of an [Article] to be displayed on the UI.
 *
 * @property[id] A unique identifier for this article.
 * @property[title] The title of the article, potentially with author information formatted.
 * @property[publishedAt] A formatted string of when the article was published.
 * @property[image] The [ImageModel] for the article's hero image.
 * @property[url] The URL to the actual article source.
 * @property[summary] A short summary of the article.
 * @property[isFeatured] Indicates if this article should be highlighted or featured.
 * @property[isPlaceholder] True if this display model is just a placeholder, false otherwise.
 */
data class ArticleDisplayModel(
    val id: String,
    val title: AnnotatedString,
    val publishedAt: String,
    val image: ImageModel,
    val url: String,
    val summary: String,
    val isFeatured: Boolean,
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
        image = ImageModel.Remote(article.imageUrl),
        url = article.url,
        summary = article.summary,
        isFeatured = article.isFeatured,
    )

    companion object {
        fun placeholder(): ArticleDisplayModel {
            return ArticleDisplayModel(
                id = "",
                title = AnnotatedString("Placeholder Title Should Be Long"),
                image = ImageModel.Placeholder,
                publishedAt = "Month 00, 0000",
                url = "",
                summary = "Placeholder Summary\nMultiline",
                isFeatured = false,
                isPlaceholder = true,
            )
        }
    }
}
