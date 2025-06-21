package com.adammcneilly.spacenerd.shared.data.agency.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.adammcneilly.spacenerd.shared.data.agency.local.room.dto.RoomAgencyDTO
import kotlinx.coroutines.flow.Flow

@Dao
interface RoomAgencyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrReplaceAgency(
        agency: RoomAgencyDTO,
    )

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreAgency(
        agency: RoomAgencyDTO,
    )

    @Query(
        """
        SELECT * 
        FROM agencies 
        WHERE id = :id
        """,
    )
    fun getAgency(
        id: String,
    ): Flow<RoomAgencyDTO>
}
