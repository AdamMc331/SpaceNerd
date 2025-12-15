package com.adammcneilly.spacenerd

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * The Android [Application] instance for the Space Nerd app.
 */
@HiltAndroidApp
class SpaceNerdApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}
