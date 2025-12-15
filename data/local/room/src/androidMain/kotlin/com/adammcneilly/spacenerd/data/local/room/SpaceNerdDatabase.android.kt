package com.adammcneilly.spacenerd.data.local.room

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

class AndroidDatabaseBuilderProvider(
    private val context: Context,
) : DatabaseBuilderProvider {
    override fun provideBuilder(): RoomDatabase.Builder<SpaceNerdDatabase> {
        val dbFile = context.getDatabasePath(DATABASE_NAME)
        return Room.databaseBuilder<SpaceNerdDatabase>(
            context = context,
            name = dbFile.absolutePath,
        )
    }
}
