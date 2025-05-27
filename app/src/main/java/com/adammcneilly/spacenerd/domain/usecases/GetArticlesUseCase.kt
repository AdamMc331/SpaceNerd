package com.adammcneilly.spacenerd.domain.usecases

import com.adammcneilly.spacenerd.core.displaymodels.ArticleDisplayModel
import com.adammcneilly.spacenerd.data.repositories.ArticleRepository
import javax.inject.Inject

class GetArticlesUseCase @Inject constructor(
    private val repository: ArticleRepository,
) {
    suspend fun invoke(): List<ArticleDisplayModel> {
        return repository.getArticles().map(::ArticleDisplayModel)
    }
}
