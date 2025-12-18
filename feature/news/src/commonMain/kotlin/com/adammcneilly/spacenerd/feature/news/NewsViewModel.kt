package com.adammcneilly.spacenerd.feature.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adammcneilly.spacenerd.core.displaymodels.ArticleDisplayModel
import com.adammcneilly.spacenerd.core.models.SyncStatus
import com.adammcneilly.spacenerd.data.article.api.ArticleRepository
import com.adammcneilly.spacenerd.feature.news.ui.NewsUiEvent
import com.adammcneilly.spacenerd.feature.news.ui.NewsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
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
            combine(
                articleRepository.getArticles(),
                articleRepository.syncStatus,
            ) { articles, syncStatus ->
                val displayModelResult = articles.map { article ->
                    ArticleDisplayModel(article)
                }

                val newStatus = if (
                    displayModelResult.isNotEmpty() &&
                    syncStatus != SyncStatus.Initial &&
                    syncStatus != SyncStatus.Refresh
                ) {
                    SyncStatus.None
                } else {
                    syncStatus
                }

                NewsUiState(
                    articles = displayModelResult,
                    syncStatus = newStatus,
                    selectedArticle = mutableState.value.selectedArticle,
                )
            }
                .collectLatest { uiState ->
                    mutableState.value = uiState
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
