package com.adammcneilly.spacenerd.shared.di

import com.adammcneilly.spacenerd.data.local.room.AndroidDatabaseBuilderProvider
import com.adammcneilly.spacenerd.data.local.room.DatabaseBuilderProvider
import com.adammcneilly.spacenerd.feature.launchlist.AndroidLaunchWidgetManager
import com.adammcneilly.spacenerd.feature.launchlist.LaunchWidgetManager
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

actual val nativeModule: Module = module {
    single<LaunchWidgetManager> {
        AndroidLaunchWidgetManager(androidContext())
    }

    single<DatabaseBuilderProvider> {
        AndroidDatabaseBuilderProvider(androidContext())
    }
}
