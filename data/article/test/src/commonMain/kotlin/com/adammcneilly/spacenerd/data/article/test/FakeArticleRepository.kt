package com.adammcneilly.spacenerd.data.article.test

import com.adammcneilly.spacenerd.core.models.Article
import com.adammcneilly.spacenerd.data.article.api.ArticleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeArticleRepository : ArticleRepository {
    lateinit var articles: List<Article>

    override fun getArticles(): Flow<List<Article>> {
        return flowOf(articles)
    }
}
