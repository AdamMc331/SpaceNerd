package com.adammcneilly.spacenerd.feature.launchdetail

import app.cash.turbine.test
import com.adammcneilly.spacenerd.core.displaymodels.LaunchDisplayModel
import com.adammcneilly.spacenerd.core.models.test.testLaunch
import com.adammcneilly.spacenerd.data.launch.api.LaunchRepository
import com.adammcneilly.spacenerd.feature.launchdetail.ui.LaunchDetailUiState
import com.varabyte.truthish.assertThat
import dev.mokkery.answering.returns
import dev.mokkery.every
import dev.mokkery.mock
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.datetime.TimeZone
import kotlin.test.Test

@OptIn(ExperimentalCoroutinesApi::class)
class LaunchDetailViewModelTest {
    private val launchRepository: LaunchRepository = mock()
    private lateinit var viewModel: LaunchDetailViewModel

    private fun buildSubject() {
        viewModel = LaunchDetailViewModel(
            launchId = testLaunch.id,
            launchRepository = launchRepository,
        )
    }

    @Test
    fun observeInitialState() =
        runTest {
            every {
                launchRepository.getLaunch(testLaunch.id)
            } returns flow { }

            buildSubject()

            viewModel.state.test {
                val initialState = awaitItem()
                assertThat(initialState).isEqualTo(LaunchDetailUiState.default())

                cancelAndIgnoreRemainingEvents()
            }
        }

    @Test
    fun mapLaunchDetailResponse() =
        runTest {
            every {
                launchRepository.getLaunch(testLaunch.id)
            } returns flowOf(testLaunch)

            buildSubject()

            val expectedState = LaunchDetailUiState(
                launch = LaunchDisplayModel(
                    launch = testLaunch,
                    timeZone = TimeZone.UTC,
                ),
            )

            viewModel.state.test {
                assertThat(awaitItem()).isEqualTo(expectedState)

                cancelAndIgnoreRemainingEvents()
            }
        }
}
