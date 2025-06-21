package com.adammcneilly.spacenerd.shared.data.launch.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.adammcneilly.spacenerd.shared.core.models.Launch
import com.adammcneilly.spacenerd.shared.data.agency.local.room.dto.RoomAgencyDTO
import com.adammcneilly.spacenerd.shared.data.launch.local.room.dto.RoomLaunchDTO
import com.adammcneilly.spacenerd.shared.data.launch.local.room.dto.RoomLaunchDetailDTO
import com.adammcneilly.spacenerd.shared.data.launch.local.room.dto.RoomLaunchPadDTO
import kotlinx.coroutines.flow.Flow

@Dao
interface RoomLaunchDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLaunches(
        launches: List<RoomLaunchDTO>,
    )

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreAgency(
        agency: RoomAgencyDTO,
    )

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLaunchPad(
        launchPad: RoomLaunchPadDTO,
    )

    suspend fun insertDomainLaunches(
        launches: List<Launch>,
    ) {
        launches.forEach { launch ->
            val padDto = launch.pad?.let(::RoomLaunchPadDTO)
            if (padDto != null) {
                insertLaunchPad(padDto)
            }

            val agencyDto = launch.agency?.let(::RoomAgencyDTO)
            if (agencyDto != null) {
                insertOrIgnoreAgency(agencyDto)
            }

            val launchDto = RoomLaunchDTO(launch)
            insertLaunches(listOf(launchDto))
        }
    }

    @Transaction
    @Query(
        """
        SELECT * 
        FROM launches 
        WHERE 
            (:before IS NULL OR launchTime <= :before) 
            AND (:after IS NULL OR launchTime >= :after)
        ORDER BY launchTime ASC
        """,
    )
    fun getLaunches(
        before: String?,
        after: String?,
    ): Flow<List<RoomLaunchDetailDTO>>

    @Transaction
    @Query(
        """
        SELECT * 
        FROM launches 
        WHERE id == :id  
        """,
    )
    fun getLaunch(
        id: String,
    ): Flow<RoomLaunchDetailDTO>
}
