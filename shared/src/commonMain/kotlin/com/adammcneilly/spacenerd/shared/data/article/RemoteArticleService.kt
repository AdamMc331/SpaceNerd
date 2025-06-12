package com.adammcneilly.spacenerd.shared.data.article

import com.adammcneilly.spacenerd.shared.core.models.Article

interface RemoteArticleService {
    suspend fun getArticles(): Result<List<Article>>
}
