package com.adammcneilly.spacenerd.data.repositories

import com.adammcneilly.spacenerd.core.models.Article

interface RemoteArticleRepository {
    suspend fun getArticles(): List<Article>
}
