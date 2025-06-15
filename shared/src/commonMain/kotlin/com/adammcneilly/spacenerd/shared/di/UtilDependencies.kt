package com.adammcneilly.spacenerd.shared.di

import com.adammcneilly.spacenerd.shared.datetime.DateTimeProvider
import com.adammcneilly.spacenerd.shared.datetime.SystemDateTimeProvider

object UtilDependencies {
    val dateTimeProvider: DateTimeProvider by lazy {
        SystemDateTimeProvider()
    }
}
