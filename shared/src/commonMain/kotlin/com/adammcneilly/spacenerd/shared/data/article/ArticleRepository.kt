package com.adammcneilly.spacenerd.shared.data.article

import com.adammcneilly.spacenerd.shared.core.models.Article
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {
    fun getArticles(): Flow<List<Article>>
}
