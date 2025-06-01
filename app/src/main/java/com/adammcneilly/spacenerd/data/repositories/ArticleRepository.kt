package com.adammcneilly.spacenerd.data.repositories

import com.adammcneilly.spacenerd.core.models.Article
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {
    fun getArticles(): Flow<Result<List<Article>>>
}
