package com.adammcneilly.spacenerd.shared.di

import com.adammcneilly.spacenerd.data.local.room.DatabaseBuilderProvider
import com.adammcneilly.spacenerd.data.local.room.IOSDatabaseBuilderProvider
import com.adammcneilly.spacenerd.feature.launchlist.AndroidLaunchWidgetManager
import com.adammcneilly.spacenerd.feature.launchlist.LaunchWidgetManager
import org.koin.core.module.Module
import org.koin.dsl.module

actual val nativeModule: Module = module {
    single<LaunchWidgetManager> {
        IOSLaunchWidgetManager()
    }

    single<DatabaseBuilderProvider> {
        IOSDatabaseBuilderProvider()
    }
}
