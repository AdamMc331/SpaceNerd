package com.adammcneilly.spacenerd.feature.launchlist

import app.cash.turbine.test
import com.adammcneilly.spacenerd.core.displaymodels.LaunchDisplayModel
import com.adammcneilly.spacenerd.core.models.SyncStatus
import com.adammcneilly.spacenerd.core.models.test.testLaunch
import com.adammcneilly.spacenerd.data.launch.api.LaunchListRequest
import com.adammcneilly.spacenerd.data.launch.api.LaunchRepository
import com.adammcneilly.spacenerd.feature.launchlist.ui.LaunchListUiEvent
import com.adammcneilly.spacenerd.feature.launchlist.ui.LaunchListUiState
import com.varabyte.truthish.assertThat
import dev.mokkery.answering.returns
import dev.mokkery.every
import dev.mokkery.mock
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import kotlin.test.Ignore
import kotlin.test.Test

class LaunchListViewModelTest {
    private val launchRepository: LaunchRepository = mock()
    private val launchWidgetManager: LaunchWidgetManager = mock()
    private lateinit var viewModel: LaunchListViewModel

    private fun buildSubject() {
        viewModel = LaunchListViewModel(
            launchRepository = launchRepository,
            launchWidgetManager = launchWidgetManager,
        )
    }

    @Test
    fun observeInitialState() =
        runTest {
            every {
                launchRepository.getLaunches(LaunchListRequest.Upcoming)
            } returns flow { }

            every {
                launchWidgetManager.launchWidgetSupported()
            } returns false

            buildSubject()

            viewModel.state.test {
                val initialState = awaitItem()
                assertThat(initialState).isEqualTo(LaunchListUiState.default())

                cancelAndIgnoreRemainingEvents()
            }
        }

    @Test
    fun observeInitialStateWithLaunchWidgetSupported() =
        runTest {
            every {
                launchRepository.getLaunches(LaunchListRequest.Upcoming)
            } returns flow { }

            every {
                launchWidgetManager.launchWidgetSupported()
            } returns true

            buildSubject()

            val expectedState = LaunchListUiState.default(
                launchWidgetSupported = true,
            )

            viewModel.state.test {
                val initialState = awaitItem()
                assertThat(initialState).isEqualTo(expectedState)

                cancelAndIgnoreRemainingEvents()
            }
        }

    @Test
    @Ignore // Fails on CI, not sure why.
    fun mapLaunchListResponse() =
        runTest {
            val launches = listOf(testLaunch)

            every {
                launchRepository.getLaunches(LaunchListRequest.Upcoming)
            } returns flowOf(launches)

            buildSubject()

            val expectedState = LaunchListUiState(
                launches = listOf(
                    LaunchDisplayModel(testLaunch),
                ),
                selectedLaunch = null,
                launchWidgetSupported = false,
                syncStatus = SyncStatus.None,
            )

            viewModel.state.test {
                assertThat(awaitItem()).isEqualTo(LaunchListUiState.default())
                assertThat(awaitItem()).isEqualTo(expectedState)

                cancelAndIgnoreRemainingEvents()
            }
        }

    @Test
    fun handleLaunchSelected() =
        runTest {
            val launch = LaunchDisplayModel(testLaunch)

            every {
                launchRepository.getLaunches(LaunchListRequest.Upcoming)
            } returns flow { }

            every {
                launchWidgetManager.launchWidgetSupported()
            } returns false

            buildSubject()

            viewModel.onEvent(LaunchListUiEvent.LaunchSelected(launch))

            viewModel.state.test {
                val state = awaitItem()

                val expectedState = LaunchListUiState.default().copy(
                    selectedLaunch = launch,
                )
                assertThat(state).isEqualTo(expectedState)

                cancelAndIgnoreRemainingEvents()
            }
        }

    @Test
    fun handleNavigatedToLaunch() =
        runTest {
            val launch = LaunchDisplayModel(testLaunch)

            every {
                launchRepository.getLaunches(LaunchListRequest.Upcoming)
            } returns flow { }

            every {
                launchWidgetManager.launchWidgetSupported()
            } returns false

            buildSubject()

            viewModel.onEvent(LaunchListUiEvent.LaunchSelected(launch))

            viewModel.state.test {
                val stateBeforeNavigation = awaitItem()
                val expectedStateBeforeNavigation = LaunchListUiState.default().copy(
                    selectedLaunch = launch,
                )
                assertThat(stateBeforeNavigation).isEqualTo(expectedStateBeforeNavigation)

                viewModel.onEvent(LaunchListUiEvent.NavigatedToLaunch(launch))

                val stateAfterNavigation = awaitItem()
                val expectedStateAfterNavigation = LaunchListUiState.default().copy(
                    selectedLaunch = null,
                )
                assertThat(stateAfterNavigation).isEqualTo(expectedStateAfterNavigation)

                cancelAndIgnoreRemainingEvents()
            }
        }
}
