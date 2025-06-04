package com.adammcneilly.spacenerd.data.article.remote

import com.adammcneilly.spacenerd.core.models.Article

internal interface RemoteArticleService {
    suspend fun getArticles(): Result<List<Article>>
}
