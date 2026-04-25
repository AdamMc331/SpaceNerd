package com.adammcneilly.spacenerd.data.local.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.adammcneilly.spacenerd.core.models.SpaceStationStatus
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomAgencyDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomSpaceStationAgencyCrossRefDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomSpaceStationDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomSpaceStationDetailDTO
import kotlinx.coroutines.flow.Flow

/**
 * This is the Room database access object for the space stations table.
 */
@Dao
interface RoomSpaceStationDao : BaseSpaceStationDao {
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

    @Transaction
    @Query(
        """
            SELECT *
            FROM space_stations
            WHERE spaceStationId = :id
        """,
    )
    fun getSpaceStation(
        id: String,
    ): Flow<RoomSpaceStationDetailDTO>
}
