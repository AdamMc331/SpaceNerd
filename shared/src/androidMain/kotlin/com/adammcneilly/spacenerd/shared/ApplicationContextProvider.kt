package com.adammcneilly.spacenerd.shared

import android.content.Context

object ApplicationContextProvider {
    private lateinit var applicationContext: Context

    fun initialize(context: Context) {
        applicationContext = context.applicationContext
    }

    fun getApplicationContext(): Context {
        return applicationContext
    }
}
