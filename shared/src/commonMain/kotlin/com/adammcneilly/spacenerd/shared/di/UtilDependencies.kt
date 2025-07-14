package com.adammcneilly.spacenerd.shared.di

import com.adammcneilly.spacenerd.core.datetime.DateTimeProvider
import com.adammcneilly.spacenerd.core.datetime.SystemDateTimeProvider
import org.koin.dsl.module

val utilModule = module {
    single<DateTimeProvider> {
        SystemDateTimeProvider()
    }
}
