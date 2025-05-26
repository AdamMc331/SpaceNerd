package com.adammcneilly.spacenerd.screens.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adammcneilly.spacenerd.domain.usecases.GetArticlesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel
    @Inject
    constructor(
        private val getArticlesUseCase: GetArticlesUseCase,
    ) : ViewModel() {
        private val mutableState = MutableStateFlow(NewsState.default())
        val state = mutableState.asStateFlow()

        init {
            viewModelScope.launch {
                val articles = getArticlesUseCase.invoke()

                mutableState.update { currentState ->
                    currentState.copy(
                        articles = articles,
                    )
                }
            }
        }
    }
