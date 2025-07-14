package com.adammcneilly.spacenerd.data.local.room

import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Android implementation of database builder
 */
actual fun getDatabaseBuilder(): RoomDatabase.Builder<SpaceNerdDatabase> {
    val context = ApplicationContextProvider.getApplicationContext()
    val dbFile = context.getDatabasePath(DATABASE_NAME)
    return Room.databaseBuilder<SpaceNerdDatabase>(
        context = context,
        name = dbFile.absolutePath,
    )
}
