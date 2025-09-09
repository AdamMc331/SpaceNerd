package com.adammcneilly.spacenerd.data.local.room.dtos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.adammcneilly.spacenerd.core.models.Article
import com.adammcneilly.spacenerd.core.models.Author
import com.adammcneilly.spacenerd.data.local.room.converters.StringListTypeConverter
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
@Entity(tableName = "articles")
@TypeConverters(StringListTypeConverter::class)
data class RoomArticleDTO(
    @PrimaryKey val articleId: String,
    val title: String,
    val imageUrl: String,
    val url: String,
    val summary: String,
    val authors: List<String>,
    val publishedAtUtc: String,
    val isFeatured: Boolean,
) {
    constructor(
        article: Article,
    ) : this(
        articleId = article.id,
        title = article.title,
        imageUrl = article.imageUrl,
        url = article.url,
        summary = article.summary,
        authors = article.authors.map { it.name },
        publishedAtUtc = article.publishedAtUtc.toString(),
        isFeatured = article.isFeatured,
    )

    fun toArticle(): Article {
        return Article(
            id = articleId,
            title = title,
            imageUrl = imageUrl,
            url = url,
            summary = summary,
            authors = authors.map { authorName ->
                Author(
                    name = authorName,
                )
            },
            publishedAtUtc = Instant.parse(publishedAtUtc),
            isFeatured = isFeatured,
        )
    }
}
