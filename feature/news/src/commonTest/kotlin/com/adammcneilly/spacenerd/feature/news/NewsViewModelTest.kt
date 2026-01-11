package com.adammcneilly.spacenerd.feature.news

import app.cash.turbine.test
import com.adammcneilly.spacenerd.core.datetime.DateTimeProvider
import com.adammcneilly.spacenerd.core.datetime.DebugTimeProvider
import com.adammcneilly.spacenerd.core.displaymodels.ArticleDisplayModel
import com.adammcneilly.spacenerd.core.models.Article
import com.adammcneilly.spacenerd.core.models.SyncStatus
import com.adammcneilly.spacenerd.core.models.test.testArticle
import com.adammcneilly.spacenerd.data.article.api.ArticleRepository
import com.adammcneilly.spacenerd.feature.news.ui.NewsUiEvent
import com.adammcneilly.spacenerd.feature.news.ui.NewsUiState
import com.varabyte.truthish.assertThat
import dev.mokkery.answering.returns
import dev.mokkery.every
import dev.mokkery.mock
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class NewsViewModelTest {
    private val articleRepository: ArticleRepository = mock()
    private val dateTimeProvider: DateTimeProvider = DebugTimeProvider()
    private lateinit var viewModel: NewsViewModel

    init {
        every {
            articleRepository.syncStatus
        } returns flowOf(SyncStatus.None)
    }

    private fun buildSubject() {
        viewModel = NewsViewModel(
            articleRepository = articleRepository,
            dateTimeProvider = dateTimeProvider,
        )
    }

    @Test
    fun observeInitialState() =
        runTest {
            every {
                articleRepository.getArticles()
            } returns flow { }

            buildSubject()

            viewModel.state.test {
                val initialState = awaitItem()
                assertThat(initialState).isEqualTo(NewsUiState.default())

                cancelAndIgnoreRemainingEvents()
            }
        }

    @Test
    fun mapArticleResponse() =
        runTest {
            val articlesFlow = MutableSharedFlow<List<Article>>(replay = 0)

            every {
                articleRepository.getArticles()
            } returns articlesFlow

            buildSubject()

            val expectedInitialState = NewsUiState.default()

            val expectedState = NewsUiState(
                articles = listOf(
                    ArticleDisplayModel(testArticle, dateTimeProvider),
                ),
                selectedArticle = null,
                syncStatus = SyncStatus.None,
            )

            viewModel.state.test {
                val initialState = awaitItem()
                assertThat(initialState).isEqualTo(expectedInitialState)

                articlesFlow.emit(listOf(testArticle))

                val state = awaitItem()
                assertThat(state).isEqualTo(expectedState)

                cancelAndIgnoreRemainingEvents()
            }
        }

    @Test
    fun handleArticleSelected() =
        runTest {
            val article = ArticleDisplayModel(testArticle, dateTimeProvider)

            every {
                articleRepository.getArticles()
            } returns flow { }

            buildSubject()

            val expectedState = NewsUiState.default().copy(
                selectedArticle = article,
            )

            viewModel.onEvent(NewsUiEvent.ArticleSelected(article))

            viewModel.state.test {
                val state = awaitItem()
                assertThat(state).isEqualTo(expectedState)

                cancelAndIgnoreRemainingEvents()
            }
        }

    @Test
    fun handleNavigatedToArticle() =
        runTest {
            val article = ArticleDisplayModel(testArticle, dateTimeProvider)

            every {
                articleRepository.getArticles()
            } returns flow { }

            buildSubject()

            viewModel.onEvent(NewsUiEvent.ArticleSelected(article))

            viewModel.state.test {
                val stateBeforeNavigation = awaitItem()
                val expectedStateBeforeNavigation = NewsUiState.default().copy(
                    selectedArticle = article,
                )
                assertThat(stateBeforeNavigation).isEqualTo(expectedStateBeforeNavigation)

                viewModel.onEvent(NewsUiEvent.NavigatedToArticle(article))

                val stateAfterNavigation = awaitItem()
                val expectedStateAfterNavigation = NewsUiState.default().copy(
                    selectedArticle = null,
                )
                assertThat(stateAfterNavigation).isEqualTo(expectedStateAfterNavigation)

                cancelAndIgnoreRemainingEvents()
            }
        }
}
