package com.adammcneilly.spacenerd.data.local.room.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomAstronautDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomAstronautDetailDTO
import kotlinx.coroutines.flow.Flow

@Dao
interface RoomAstronautDao : BaseAstronautDao {
    @Query(
        """
            SELECT *
            FROM astronauts
            WHERE astronautId == :astronautId
        """,
    )
    fun getAstronaut(
        astronautId: String,
    ): Flow<RoomAstronautDetailDTO>

    @Query(
        """
            SELECT *
            FROM astronauts
        """,
    )
    fun getAstronauts(): Flow<List<RoomAstronautDetailDTO>>
}
