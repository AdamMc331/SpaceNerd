package com.adammcneilly.spacenerd.data.local.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomAstronautDTO
import kotlinx.coroutines.flow.Flow

@Dao
interface RoomAstronautDao {
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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAstronauts(
        astronauts: List<RoomAstronautDTO>,
    )
}
