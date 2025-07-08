package com.adammcneilly.spacenerd.shared.core.models

import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
data class Article(
    val id: String,
    val title: String,
    val imageUrl: String,
    val url: String,
    val summary: String,
    val publishedAtUtc: Instant,
    val authors: List<Author>,
)
