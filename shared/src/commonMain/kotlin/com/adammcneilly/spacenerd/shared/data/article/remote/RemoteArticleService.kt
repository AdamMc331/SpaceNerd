package com.adammcneilly.spacenerd.shared.data.article.remote

import com.adammcneilly.spacenerd.shared.core.models.Article

interface RemoteArticleService {
    suspend fun getArticles(): Result<List<Article>>
}
