package com.adammcneilly.spacenerd.data.article.impl.remote.snapi

import com.adammcneilly.spacenerd.core.models.Article
import com.adammcneilly.spacenerd.core.models.Author
import com.adammcneilly.spacenerd.data.remote.snapi.test.FakeSNAPIKtorClient
import com.varabyte.truthish.assertThat
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
class SNAPIArticleServiceTest {
    private val service = SNAPIArticleService(
        client = FakeSNAPIKtorClient,
    )

    @Test
    fun getArticles() =
        runTest {
            val articles = service.getArticles()
                .getOrThrow()

            assertThat(articles).hasSize(10)

            val expectedArticle = Article(
                id = "32551",
                title = "Hera observes asteroids as DART reveals more about its destination",
                imageUrl = "https://www.nasaspaceflight.com/wp-content/uploads/2025/08/Hera_her_CubeSats_and_their_rocky_target_destination.png",
                url = "https://www.nasaspaceflight.com/2025/08/hera-dart-reveals-destination/",
                summary = "Travelling through the asteroid belt, the European Space Agency’s Hera spacecraft has taken its first…\nThe post Hera observes asteroids as DART reveals more about its destination appeared first on NASASpaceFlight.com.",
                publishedAtUtc = Instant.parse("2025-08-10T21:35:57Z"),
                authors = listOf(
                    Author(
                        name = "Martijn Luinstra",
                    ),
                ),
                isFeatured = false,
            )

            assertThat(articles[0]).isEqualTo(expectedArticle)
        }
}
