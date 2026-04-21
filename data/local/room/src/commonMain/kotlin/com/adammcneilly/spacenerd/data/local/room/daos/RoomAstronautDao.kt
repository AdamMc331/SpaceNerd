package com.adammcneilly.spacenerd.data.local.room.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomAstronautDTO
import kotlinx.coroutines.flow.Flow

@Dao
interface RoomAstronautDao {
    @Upsert
    suspend fun upsertAstronauts(
        astronauts: List<RoomAstronautDTO>,
    )

    @Query(
        """
            SELECT *
            FROM astronauts
            WHERE astronautId == :astronautId
        """,
    )
    fun getAstronaut(
        astronautId: String,
    ): Flow<RoomAstronautDTO>

    @Query(
        """
            SELECT *
            FROM astronauts
        """,
    )
    fun getAstronauts(): Flow<List<RoomAstronautDTO>>
}
