package com.adammcneilly.spacenerd

import android.app.Application
import com.adammcneilly.spacenerd.shared.ApplicationContextProvider
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SpaceNerdApp : Application() {
    override fun onCreate() {
        super.onCreate()
        ApplicationContextProvider.initialize(this)
    }
}
