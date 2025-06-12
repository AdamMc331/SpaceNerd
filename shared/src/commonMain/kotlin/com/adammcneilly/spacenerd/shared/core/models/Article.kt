package com.adammcneilly.spacenerd.shared.core.models

import kotlinx.datetime.Instant

data class Article(
    val id: String,
    val title: String,
    val imageUrl: String,
    val url: String,
    val summary: String,
    val publishedAtUtc: Instant,
    val authors: List<Author>,
)
