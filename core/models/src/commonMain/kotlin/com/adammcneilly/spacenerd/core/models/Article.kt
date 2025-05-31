package com.adammcneilly.spacenerd.core.models

data class Article(
    val id: String,
    val title: String,
    val imageUrl: String,
    val url: String,
    val summary: String,
    val authors: List<Author>,
)
