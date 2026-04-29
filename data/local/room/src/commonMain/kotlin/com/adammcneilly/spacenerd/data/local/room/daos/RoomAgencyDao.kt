package com.adammcneilly.spacenerd.data.local.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomAgencyDTO
import kotlinx.coroutines.flow.Flow

/**
 * This is the Room database access object for the agencies table.
 */
@Dao
interface RoomAgencyDao : BaseAgencyDao {
    @Query(
        """
        SELECT * 
        FROM agencies 
        WHERE agencyId = :id
        """,
    )
    fun getAgency(
        id: String,
    ): Flow<RoomAgencyDTO>
}
