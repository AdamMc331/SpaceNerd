package com.adammcneilly.spacenerd.data.local.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomAgencyDTO
import kotlinx.coroutines.flow.Flow

/**
 * This is the Room database access object for the agencies table.
 */
@Dao
interface RoomAgencyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrReplaceAgency(
        agency: RoomAgencyDTO,
    )

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
