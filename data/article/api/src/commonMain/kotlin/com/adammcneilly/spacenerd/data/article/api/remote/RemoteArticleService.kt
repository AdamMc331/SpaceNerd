package com.adammcneilly.spacenerd.data.article.api.remote

import com.adammcneilly.spacenerd.core.models.Article

/**
 * Defines any requests to a remote data source for article information.
 *
 * All functions inside this interface should be suspending, and return a singular [Result]
 * entity once the network request has completed.
 */
interface RemoteArticleService {
    suspend fun getArticles(): Result<List<Article>>
}
