package com.adammcneilly.spacenerd.shared.di

import com.adammcneilly.spacenerd.feature.news.NewsViewModel
import com.adammcneilly.spacenerd.shared.feature.launchdetail.LaunchDetailViewModel
import com.adammcneilly.spacenerd.shared.feature.launchlist.LaunchListViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        NewsViewModel(
            articleRepository = get(),
        )
    }

    viewModel {
        LaunchListViewModel(
            launchRepository = get(),
        )
    }

    viewModel { parameters ->
        LaunchDetailViewModel(
            launchId = parameters.get(),
            launchRepository = get(),
        )
    }
}
