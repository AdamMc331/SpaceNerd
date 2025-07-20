package com.adammcneilly.spacenerd.core.models.test

import com.adammcneilly.spacenerd.core.models.Article
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
val testArticle = Article(
    id = "test_article_id",
    title = "Test Article Title",
    imageUrl = "ImageUrl",
    url = "ArticleUrl",
    summary = "This is a test article summary.",
    publishedAtUtc = Instant.parse("2023-01-01T00:00:00Z"),
    authors = listOf(testAuthor),
    isFeatured = false,
)
