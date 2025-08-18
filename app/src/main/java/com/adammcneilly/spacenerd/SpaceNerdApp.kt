package com.adammcneilly.spacenerd

import android.app.Application
import com.adammcneilly.spacenerd.data.local.room.ApplicationContextProvider
import dagger.hilt.android.HiltAndroidApp

/**
 * The Android [Application] instance for the Space Nerd app. Application wide dependencies
 * such as the [ApplicationContextProvider] should be initialized here.
 */
@HiltAndroidApp
class SpaceNerdApp : Application() {
    override fun onCreate() {
        super.onCreate()
        ApplicationContextProvider.initialize(this)
    }
}
