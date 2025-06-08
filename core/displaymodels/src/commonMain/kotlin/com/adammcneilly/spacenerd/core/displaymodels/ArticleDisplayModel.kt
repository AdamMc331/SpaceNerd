package com.adammcneilly.spacenerd.core.displaymodels

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import com.adammcneilly.spacenerd.core.models.Article

data class ArticleDisplayModel(
    val id: String,
    val title: String,
    val image: ImageDisplayModel,
    val url: String,
    val summary: String,
    val authors: List<AuthorDisplayModel>,
    val isPlaceholder: Boolean = false,
) {
    constructor(
        article: Article,
    ) : this(
        id = article.id,
        title = article.title,
        image = ImageDisplayModel.Remote(article.imageUrl),
        url = article.url,
        summary = article.summary,
        authors = article.authors.map(::AuthorDisplayModel),
    )

    private val authorNames = authors.joinToString(transform = AuthorDisplayModel::name)

    val titleAuthor: AnnotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
            append(title)
        }
        append(" | ")
        append(authorNames)
    }

    companion object {
        fun placeholder(): ArticleDisplayModel {
            return ArticleDisplayModel(
                id = "",
                title = "Placeholder Title Should Be Long",
                image = ImageDisplayModel.Remote(""),
                url = "",
                summary = "Placeholder Summary\nMultiline",
                authors = emptyList(),
                isPlaceholder = true,
            )
        }
    }
}
