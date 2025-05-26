package com.adammcneilly.spacenerd.domain.usecases

import com.adammcneilly.spacenerd.core.displaymodels.ArticleDisplayModel
import com.adammcneilly.spacenerd.data.repositories.ArticleRepository

class GetArticlesUseCase(
    private val repository: ArticleRepository,
) {
    suspend fun invoke(): List<ArticleDisplayModel> = repository.getArticles().map(::ArticleDisplayModel)
}
