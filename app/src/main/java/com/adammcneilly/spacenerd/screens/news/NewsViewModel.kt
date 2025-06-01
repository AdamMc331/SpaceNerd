package com.adammcneilly.spacenerd.screens.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adammcneilly.spacenerd.core.displaymodels.ArticleDisplayModel
import com.adammcneilly.spacenerd.data.repositories.ArticleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val articleRepository: ArticleRepository,
) : ViewModel() {
    private val mutableState = MutableStateFlow(NewsState.default())
    val state = mutableState.asStateFlow()

    init {
        observeArticles()
    }

    private fun observeArticles() {
        viewModelScope.launch {
            articleRepository
                .getArticles()
                .collectLatest { articlesResult ->
                    val displayModelResult = articlesResult.map { articles ->
                        articles.map(::ArticleDisplayModel)
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
        event: NewsEvent,
    ) {
        when (event) {
            is NewsEvent.ArticleSelected -> {
                mutableState.update { currentState ->
                    currentState.copy(
                        selectedArticle = event.article,
                    )
                }
            }
            is NewsEvent.NavigatedToArticle -> {
                mutableState.update { currentState ->
                    currentState.copy(
                        selectedArticle = null,
                    )
                }
            }
        }
    }
}
