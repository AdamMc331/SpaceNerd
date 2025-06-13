package com.adammcneilly.spacenerd.shared.data.local.room

import androidx.room.Room
import androidx.room.RoomDatabase
import com.adammcneilly.spacenerd.shared.ApplicationContextProvider

/**
 * Android implementation of database builder
 */
actual fun getDatabaseBuilder(): RoomDatabase.Builder<SpaceNerdDatabase> {
    val context = ApplicationContextProvider.getApplicationContext()
    val dbFile = context.getDatabasePath(DATABASE_NAME)
    return Room.databaseBuilder<SpaceNerdDatabase>(
        context = context,
        name = dbFile.absolutePath
    )
}
