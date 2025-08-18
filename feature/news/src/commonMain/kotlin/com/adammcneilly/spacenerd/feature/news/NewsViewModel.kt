package com.adammcneilly.spacenerd.feature.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adammcneilly.spacenerd.core.displaymodels.ArticleDisplayModel
import com.adammcneilly.spacenerd.data.article.api.ArticleRepository
import com.adammcneilly.spacenerd.feature.news.ui.NewsUiEvent
import com.adammcneilly.spacenerd.feature.news.ui.NewsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * This is the state management container for the news list screen. It pulls articles
 * from the supplied [articleRepository] and exposes a UI state to render via the [state] Flow.
 */
class NewsViewModel(
    private val articleRepository: ArticleRepository,
) : ViewModel() {
    private val mutableState = MutableStateFlow(NewsUiState.default())
    val state = mutableState.asStateFlow()

    init {
        observeArticles()
    }

    private fun observeArticles() {
        viewModelScope.launch {
            articleRepository
                .getArticles()
                .collectLatest { articles ->
                    val displayModelResult = articles.map { article ->
                        ArticleDisplayModel(article)
                    }

                    mutableState.update { currentState ->
                        currentState.copy(
                            articles = displayModelResult,
                        )
                    }
                }
        }
    }

    fun onEvent(
        event: NewsUiEvent,
    ) {
        when (event) {
            is NewsUiEvent.ArticleSelected -> {
                mutableState.update { currentState ->
                    currentState.copy(
                        selectedArticle = event.article,
                    )
                }
            }
            is NewsUiEvent.NavigatedToArticle -> {
                mutableState.update { currentState ->
                    currentState.copy(
                        selectedArticle = null,
                    )
                }
            }
        }
    }
}
