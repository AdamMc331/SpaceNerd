package com.adammcneilly.spacenerd.data.local.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.adammcneilly.spacenerd.core.models.SpaceStationStatus
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomSpaceStationDTO
import kotlinx.coroutines.flow.Flow

/**
 * This is the Room database access object for the space stations table.
 */
@Dao
interface RoomSpaceStationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrReplaceSpaceStations(
        stations: List<RoomSpaceStationDTO>,
    )

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreSpaceStations(
        stations: List<RoomSpaceStationDTO>,
    )

    @Query(
        """
            SELECT *
            FROM space_stations
            WHERE (:status IS NULL OR status = :status)
            ORDER BY founded DESC
        """,
    )
    fun getSpaceStations(
        status: SpaceStationStatus?,
    ): Flow<List<RoomSpaceStationDTO>>

    @Query(
        """
            SELECT *
            FROM space_stations
            WHERE id = :id
        """,
    )
    fun getSpaceStation(
        id: String,
    ): Flow<RoomSpaceStationDTO>
}
