package com.adammcneilly.spacenerd.shared.di

import com.adammcneilly.spacenerd.shared.datetime.DateTimeProvider
import com.adammcneilly.spacenerd.shared.datetime.SystemDateTimeProvider
import org.koin.dsl.module

val utilModule = module {
    single<DateTimeProvider> {
        SystemDateTimeProvider()
    }
}

object UtilDependencies {
    val dateTimeProvider: DateTimeProvider by lazy {
        SystemDateTimeProvider()
    }
}
