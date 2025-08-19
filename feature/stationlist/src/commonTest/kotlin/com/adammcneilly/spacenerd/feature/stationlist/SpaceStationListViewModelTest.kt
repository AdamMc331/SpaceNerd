package com.adammcneilly.spacenerd.feature.stationlist

import app.cash.turbine.test
import com.adammcneilly.spacenerd.core.displaymodels.SpaceStationDisplayModel
import com.adammcneilly.spacenerd.core.models.SpaceStationStatus
import com.adammcneilly.spacenerd.core.models.test.testSpaceStation
import com.adammcneilly.spacenerd.data.stations.api.SpaceStationListRequest
import com.adammcneilly.spacenerd.data.stations.api.SpaceStationRepository
import com.adammcneilly.spacenerd.feature.stationlist.ui.SpaceStationListUiEvent
import com.adammcneilly.spacenerd.feature.stationlist.ui.SpaceStationListUiState
import com.varabyte.truthish.assertThat
import dev.mokkery.answering.returns
import dev.mokkery.every
import dev.mokkery.mock
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

@OptIn(ExperimentalCoroutinesApi::class)
class SpaceStationListViewModelTest {
    private val spaceStationRepository: SpaceStationRepository = mock()
    private lateinit var viewModel: SpaceStationListViewModel

    private fun buildSubject() {
        viewModel = SpaceStationListViewModel(
            spaceStationRepository = spaceStationRepository,
            dispatcher = UnconfinedTestDispatcher(),
        )
    }

    @Test
    fun observeInitialState() =
        runTest {
            val request = SpaceStationListRequest(
                status = SpaceStationStatus.Active,
            )

            every {
                spaceStationRepository.getStations(request)
            } returns flow { }

            buildSubject()

            viewModel.state.test {
                val initialState = awaitItem()
                assertThat(initialState).isEqualTo(SpaceStationListUiState.default())

                cancelAndIgnoreRemainingEvents()
            }
        }

    @Test
    fun mapStationListResponse() =
        runTest {
            val stations = listOf(testSpaceStation)
            val request = SpaceStationListRequest(status = SpaceStationStatus.Active)

            every {
                spaceStationRepository.getStations(request)
            } returns flowOf(stations)

            buildSubject()

            val expectedState = SpaceStationListUiState(
                stations = listOf(
                    SpaceStationDisplayModel(testSpaceStation),
                ),
                selectedStation = null,
            )

            viewModel.state.test {
                assertThat(awaitItem()).isEqualTo(expectedState)

                cancelAndIgnoreRemainingEvents()
            }
        }

    @Test
    fun handleStationSelected() =
        runTest {
            val station = SpaceStationDisplayModel(testSpaceStation)
            val request = SpaceStationListRequest(
                status = SpaceStationStatus.Active,
            )

            every {
                spaceStationRepository.getStations(request)
            } returns flow { }

            buildSubject()

            viewModel.onEvent(SpaceStationListUiEvent.StationSelected(station))

            viewModel.state.test {
                val state = awaitItem()

                val expectedState = SpaceStationListUiState.default().copy(
                    selectedStation = station,
                )
                assertThat(state).isEqualTo(expectedState)

                cancelAndIgnoreRemainingEvents()
            }
        }

    @Test
    fun handleNavigatedToStation() =
        runTest {
            val station = SpaceStationDisplayModel(testSpaceStation)
            val request = SpaceStationListRequest(
                status = SpaceStationStatus.Active,
            )

            every {
                spaceStationRepository.getStations(request)
            } returns flow { }

            buildSubject()

            viewModel.onEvent(SpaceStationListUiEvent.StationSelected(station))

            viewModel.state.test {
                val stateBeforeNavigation = awaitItem()
                val expectedStateBeforeNavigation = SpaceStationListUiState.default().copy(
                    selectedStation = station,
                )
                assertThat(stateBeforeNavigation).isEqualTo(expectedStateBeforeNavigation)

                viewModel.onEvent(SpaceStationListUiEvent.NavigatedToStation(station))

                val stateAfterNavigation = awaitItem()
                val expectedStateAfterNavigation = SpaceStationListUiState.default().copy(
                    selectedStation = null,
                )
                assertThat(stateAfterNavigation).isEqualTo(expectedStateAfterNavigation)

                cancelAndIgnoreRemainingEvents()
            }
        }
}
