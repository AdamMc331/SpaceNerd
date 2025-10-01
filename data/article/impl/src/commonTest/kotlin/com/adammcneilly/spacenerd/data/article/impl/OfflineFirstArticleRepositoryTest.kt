package com.adammcneilly.spacenerd.data.article.impl

import app.cash.turbine.test
import com.adammcneilly.spacenerd.core.models.test.testArticle
import com.adammcneilly.spacenerd.data.article.api.local.LocalArticleService
import com.adammcneilly.spacenerd.data.article.api.remote.RemoteArticleService
import com.varabyte.truthish.assertThat
import dev.mokkery.answering.returns
import dev.mokkery.everySuspend
import dev.mokkery.matcher.any
import dev.mokkery.mock
import dev.mokkery.verify.VerifyMode
import dev.mokkery.verifySuspend
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
class OfflineFirstArticleRepositoryTest {
    private val localArticleService = mock<LocalArticleService>()
    private val remoteArticleService = mock<RemoteArticleService>()

    private val repository = OfflineFirstArticleRepository(
        localArticleService = localArticleService,
        remoteArticleService = remoteArticleService,
    )

    @Test
    fun `getArticles fetches and saves from remote when cache is stale`() =
        runTest {
            val remoteArticles = listOf(testArticle.copy(title = "Remote Article"))
            val localArticles = listOf(testArticle.copy(title = "Local Article"))

            everySuspend { localArticleService.isCacheStale() } returns true
            everySuspend { remoteArticleService.getArticles() } returns Result.success(remoteArticles)
            everySuspend { localArticleService.getArticles() } returns flowOf(localArticles)
            everySuspend { localArticleService.saveArticles(any()) } returns Unit

            repository.getArticles().test {
                val articles = awaitItem()
                assertThat(articles).isEqualTo(localArticles)

                verifySuspend {
                    remoteArticleService.getArticles()
                }

                verifySuspend {
                    localArticleService.saveArticles(remoteArticles)
                }

                cancelAndIgnoreRemainingEvents()
            }
        }

    @Test
    fun `getArticles does not sync with remote if cache is not stale`() =
        runTest {
            val remoteArticles = listOf(testArticle.copy(title = "Remote Article"))
            val localArticles = listOf(testArticle.copy(title = "Local Article"))

            everySuspend { localArticleService.isCacheStale() } returns false
            everySuspend { remoteArticleService.getArticles() } returns Result.success(remoteArticles)
            everySuspend { localArticleService.getArticles() } returns flowOf(localArticles)
            everySuspend { localArticleService.saveArticles(any()) } returns Unit

            repository.getArticles().test {
                val articles = awaitItem()
                assertThat(articles).isEqualTo(localArticles)

                verifySuspend(VerifyMode.exactly(0)) {
                    remoteArticleService.getArticles()
                }

                verifySuspend(VerifyMode.exactly(0)) {
                    localArticleService.saveArticles(any())
                }

                cancelAndIgnoreRemainingEvents()
            }
        }
}
