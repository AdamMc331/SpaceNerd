package com.adammcneilly.spacenerd.shared.di

import com.adammcneilly.spacenerd.shared.feature.news.NewsViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        NewsViewModel(
            articleRepository = get(),
        )
    }
}
