package com.adammcneilly.spacenerd.shared.data.article.remote.snapi.dto

import com.adammcneilly.spacenerd.shared.core.models.Article
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@Serializable
data class SNAPIArticleDTO(
    @SerialName(value = "authors")
    val authors: List<SNAPIAuthorDTO>? = null,
    @SerialName(value = "events")
    val events: List<SNAPIEventDTO>? = null,
    @SerialName(value = "featured")
    val featured: Boolean? = null,
    @SerialName(value = "id")
    val id: Int? = null,
    @SerialName(value = "image_url")
    val imageUrl: String? = null,
    @SerialName(value = "launches")
    val launches: List<SNAPILaunchDTO>? = null,
    @SerialName(value = "news_site")
    val newsSite: String? = null,
    @SerialName(value = "published_at")
    val publishedAt: String? = null,
    @SerialName(value = "summary")
    val summary: String? = null,
    @SerialName(value = "title")
    val title: String? = null,
    @SerialName(value = "updated_at")
    val updatedAt: String? = null,
    @SerialName(value = "url")
    val url: String? = null,
) {
    @OptIn(ExperimentalTime::class)
    fun toArticle(): Article {
        return Article(
            id = this.id.toString(),
            title = this.title?.trim().orEmpty(),
            imageUrl = this.imageUrl.orEmpty(),
            url = this.url.orEmpty(),
            summary = this.summary?.trim().orEmpty(),
            authors = this.authors?.map(SNAPIAuthorDTO::toAuthor).orEmpty(),
            publishedAtUtc = Instant.parse(this.publishedAt.orEmpty()),
        )
    }
}
