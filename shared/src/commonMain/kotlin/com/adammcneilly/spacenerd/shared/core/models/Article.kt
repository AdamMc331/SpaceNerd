package com.adammcneilly.spacenerd.shared.core.models

import kotlin.time.ExperimentalTime
import kotlin.time.Instant

/**
 * Represents a news article related to space.
 * @property[id] A unique identifier for this article.
 * @property[title] The title of the article.
 * @property[imageUrl] The URL for a hero image for this article.
 * @property[url] The URL to the actual article source.
 * @property[summary] A short summary of the article.
 * @property[publishedAtUtc] The [Instant] that this article was published.
 * @property[authors] A list of [Author] entities who wrote this article.
 * @property[featured] Indicates if this article should be highlighted or featured.
 */
@OptIn(ExperimentalTime::class)
data class Article(
    val id: String,
    val title: String,
    val imageUrl: String,
    val url: String,
    val summary: String,
    val publishedAtUtc: Instant,
    val authors: List<Author>,
    val featured: Boolean,
)
