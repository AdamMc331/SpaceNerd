package com.adammcneilly.spacenerd.data.local.room

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.adammcneilly.spacenerd.data.local.room.daos.RoomAgencyDao
import com.adammcneilly.spacenerd.data.local.room.daos.RoomArticleDao
import com.adammcneilly.spacenerd.data.local.room.daos.RoomAstronautDao
import com.adammcneilly.spacenerd.data.local.room.daos.RoomCacheTimestampDao
import com.adammcneilly.spacenerd.data.local.room.daos.RoomExpeditionDao
import com.adammcneilly.spacenerd.data.local.room.daos.RoomLaunchDao
import com.adammcneilly.spacenerd.data.local.room.daos.RoomSpaceStationDao
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomAgencyDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomArticleDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomAstronautDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomAstronautRoleDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomCacheTimestampDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomCrewMemberDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomExpeditionDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomLaunchDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomLaunchPadDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomMissionDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomRocketDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomSpaceStationAgencyCrossRefDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomSpaceStationDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

/**
 * This is our implementation of a Room [Database] with all tables used in the Space Nerd app.
 */
@Database(
    version = 1,
    entities = [
        RoomAgencyDTO::class,
        RoomArticleDTO::class,
        RoomAstronautDTO::class,
        RoomAstronautRoleDTO::class,
        RoomCacheTimestampDTO::class,
        RoomCrewMemberDTO::class,
        RoomExpeditionDTO::class,
        RoomLaunchDTO::class,
        RoomLaunchPadDTO::class,
        RoomMissionDTO::class,
        RoomRocketDTO::class,
        RoomSpaceStationDTO::class,
        RoomSpaceStationAgencyCrossRefDTO::class,
    ],
)
@ConstructedBy(SpaceNerdDatabaseConstructor::class)
abstract class SpaceNerdDatabase : RoomDatabase() {
    abstract fun agencyDao(): RoomAgencyDao

    abstract fun articleDao(): RoomArticleDao

    abstract fun astronautDao(): RoomAstronautDao

    abstract fun cacheTimestampDao(): RoomCacheTimestampDao

    abstract fun expeditionDao(): RoomExpeditionDao

    abstract fun launchDao(): RoomLaunchDao

    abstract fun spaceStationDao(): RoomSpaceStationDao
}

/**
 * The Room compiler generates the `actual` implementations.
 */
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object SpaceNerdDatabaseConstructor : RoomDatabaseConstructor<SpaceNerdDatabase> {
    override fun initialize(): SpaceNerdDatabase
}

/**
 * Database name constant
 */
internal const val DATABASE_NAME = "spacenerd.db"

/**
 * Create the database builder - expect/actual implementation per platform
 */
expect fun getDatabaseBuilder(): RoomDatabase.Builder<SpaceNerdDatabase>

/**
 * Get database instance - singleton pattern
 */
fun getDatabase(): SpaceNerdDatabase {
    return getDatabaseBuilder()
        .setQueryCoroutineContext(Dispatchers.IO)
        .setDriver(BundledSQLiteDriver()) // Essential for KMP
        // Replace with migrations when stable
        .fallbackToDestructiveMigrationOnDowngrade(dropAllTables = true)
        .build()
}
