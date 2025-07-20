package com.adammcneilly.spacenerd.data.article.api.remote

import com.adammcneilly.spacenerd.core.models.Article

interface RemoteArticleService {
    suspend fun getArticles(): Result<List<Article>>
}
