package com.adammcneilly.spacenerd.domain.usecases

import com.adammcneilly.spacenerd.core.displaymodels.ArticleDisplayModel
import com.adammcneilly.spacenerd.data.DataResult
import com.adammcneilly.spacenerd.data.repositories.ArticleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetArticlesUseCase @Inject constructor(
    private val repository: ArticleRepository,
) {
    fun invoke(): Flow<DataResult<List<ArticleDisplayModel>>> {
        return repository.getArticles().map { articlesResult ->
            articlesResult.map { articles ->
                articles.map(::ArticleDisplayModel)
            }
        }
    }
}
