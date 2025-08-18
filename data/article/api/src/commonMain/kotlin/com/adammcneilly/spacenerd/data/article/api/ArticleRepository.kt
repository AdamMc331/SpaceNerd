package com.adammcneilly.spacenerd.data.article.api

import com.adammcneilly.spacenerd.core.models.Article
import kotlinx.coroutines.flow.Flow

/**
 * Defines any data requests to retrieve article information from one or many data sources.
 *
 * Each function in this interface should return a [Flow], that emits any time the corresponding
 * data changes.
 */
interface ArticleRepository {
    fun getArticles(): Flow<List<Article>>
}
