package com.adammcneilly.spacenerd.data.repositories

import com.adammcneilly.spacenerd.core.models.Article
import com.adammcneilly.spacenerd.data.DataResult
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {
    fun getArticles(): Flow<DataResult<List<Article>>>
}
