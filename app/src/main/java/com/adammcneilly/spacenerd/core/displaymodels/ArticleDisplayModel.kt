package com.adammcneilly.spacenerd.core.displaymodels

import com.adammcneilly.spacenerd.core.models.Article

data class ArticleDisplayModel(
    val id: String,
    val title: String,
    val image: ImageDisplayModel,
    val url: String,
    val summary: String,
    val authors: List<AuthorDisplayModel>,
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

    val authorNames = authors.joinToString()
}
