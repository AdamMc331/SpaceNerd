package com.adammcneilly.spacenerd.data.repositories

import com.adammcneilly.spacenerd.shared.core.models.Article

interface RemoteArticleRepository {
    suspend fun getArticles(): Result<List<Article>>
}
