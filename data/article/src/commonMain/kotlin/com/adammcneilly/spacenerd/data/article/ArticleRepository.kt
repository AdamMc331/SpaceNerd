package com.adammcneilly.spacenerd.data.article

import com.adammcneilly.spacenerd.core.models.Article
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {
    fun getArticles(): Flow<List<Article>>
}
