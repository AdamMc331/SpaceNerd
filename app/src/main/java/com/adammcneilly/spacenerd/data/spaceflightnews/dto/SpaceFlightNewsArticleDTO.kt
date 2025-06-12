package com.adammcneilly.spacenerd.data.spaceflightnews.dto

import com.adammcneilly.spacenerd.shared.core.models.Article
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.datetime.Instant

@JsonClass(generateAdapter = true)
data class SpaceFlightNewsArticleDTO(
    @Json(name = "authors")
    val authors: List<SpaceFlightNewsAuthorDTO>? = null,
    @Json(name = "events")
    val events: List<SpaceFlightNewsEventDTO>? = null,
    @Json(name = "featured")
    val featured: Boolean? = null,
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "image_url")
    val imageUrl: String? = null,
    @Json(name = "launches")
    val launches: List<SpaceFlightNewsLaunchDTO>? = null,
    @Json(name = "news_site")
    val newsSite: String? = null,
    @Json(name = "published_at")
    val publishedAt: String? = null,
    @Json(name = "summary")
    val summary: String? = null,
    @Json(name = "title")
    val title: String? = null,
    @Json(name = "updated_at")
    val updatedAt: String? = null,
    @Json(name = "url")
    val url: String? = null,
) {
    fun toArticle(): Article {
        return Article(
            id = this.id.toString(),
            title = this.title?.trim().orEmpty(),
            imageUrl = this.imageUrl.orEmpty(),
            url = this.url.orEmpty(),
            summary = this.summary?.trim().orEmpty(),
            authors = this.authors?.map(SpaceFlightNewsAuthorDTO::toAuthor).orEmpty(),
            publishedAtUtc = Instant.parse(this.publishedAt.orEmpty()),
        )
    }
}
