package com.adammcneilly.spacenerd.data.repositories

import com.adammcneilly.spacenerd.shared.core.models.Article
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {
    fun getArticles(): Flow<List<Article>>
}
