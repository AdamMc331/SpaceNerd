package com.adammcneilly.spacenerd.data.local.room

import android.content.Context

/**
 * This is a helper object to get the [applicationContext] in order to initialize a Room database.
 *
 * We should call [initialize] when the application is created.
 */
object ApplicationContextProvider {
    private lateinit var applicationContext: Context

    fun initialize(
        context: Context,
    ) {
        applicationContext = context.applicationContext
    }

    fun getApplicationContext(): Context {
        return applicationContext
    }
}
