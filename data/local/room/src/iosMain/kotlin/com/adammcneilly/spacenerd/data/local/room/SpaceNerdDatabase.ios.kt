package com.adammcneilly.spacenerd.data.local.room

import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask

class IOSDatabaseBuilderProvider : DatabaseBuilderProvider {
    override fun provideBuilder(): RoomDatabase.Builder<SpaceNerdDatabase> {
        val documentDirectory = NSFileManager.defaultManager.URLForDirectory(
            directory = NSDocumentDirectory,
            inDomain = NSUserDomainMask,
            appropriateForURL = null,
            create = false,
            error = null,
        )
        val databasePath = documentDirectory?.path + "/$DATABASE_NAME"
        return Room.databaseBuilder<SpaceNerdDatabase>(
            name = databasePath,
        )
    }
}
