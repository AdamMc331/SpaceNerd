package com.adammcneilly.spacenerd.shared.data.article.local.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.adammcneilly.spacenerd.shared.core.models.Article
import com.adammcneilly.spacenerd.shared.core.models.Author
import com.adammcneilly.spacenerd.shared.data.local.room.typeconverters.StringListTypeConverter
import kotlinx.datetime.Instant

@Entity(tableName = "articles")
@TypeConverters(StringListTypeConverter::class)
data class RoomArticleDTO(
    @PrimaryKey
    val id: String,
    val title: String,
    val imageUrl: String,
    val url: String,
    val summary: String,
    val authors: List<String>,
    val publishedAtUtc: String,
) {
    constructor(
        article: Article,
    ) : this(
        id = article.id,
        title = article.title,
        imageUrl = article.imageUrl,
        url = article.url,
        summary = article.summary,
        authors = article.authors.map { it.name },
        publishedAtUtc = article.publishedAtUtc.toString(),
    )

    fun toArticle(): Article {
        return Article(
            id = id,
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
        )
    }
}
