package com.adammcneilly.spacenerd.shared.di

import com.adammcneilly.spacenerd.feature.astronautdetail.AstronautDetailViewModel
import com.adammcneilly.spacenerd.feature.astronautlist.AstronautListViewModel
import com.adammcneilly.spacenerd.feature.launchdetail.LaunchDetailViewModel
import com.adammcneilly.spacenerd.feature.launchlist.LaunchListViewModel
import com.adammcneilly.spacenerd.feature.news.NewsViewModel
import com.adammcneilly.spacenerd.feature.stationdetail.StationDetailViewModel
import com.adammcneilly.spacenerd.feature.stationlist.SpaceStationListViewModel
import io.ktor.http.parameters
import kotlinx.datetime.TimeZone
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { parameters ->
        AstronautDetailViewModel(
            astronautId = parameters.get(),
            astronautRepository = get(),
        )
    }

    viewModel {
        NewsViewModel(
            articleRepository = get(),
            dateTimeProvider = get(),
        )
    }

    viewModel {
        LaunchListViewModel(
            launchRepository = get(),
            launchWidgetManager = get(),
            timeZone = TimeZone.currentSystemDefault(),
        )
    }

    viewModel { parameters ->
        LaunchDetailViewModel(
            launchId = parameters.get(),
            launchRepository = get(),
            timeZone = TimeZone.currentSystemDefault(),
        )
    }

    viewModel {
        SpaceStationListViewModel(
            spaceStationRepository = get(),
        )
    }

    viewModel { parameters ->
        StationDetailViewModel(
            stationId = parameters.get(),
            stationRepository = get(),
            expeditionRepository = get(),
        )
    }

    viewModel {
        AstronautListViewModel(
            repository = get(),
        )
    }
}
