package com.adammcneilly.spacenerd.data.local.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.adammcneilly.spacenerd.core.models.Launch
import com.adammcneilly.spacenerd.core.models.Rocket
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomAgencyCountryCrossRefDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomAgencyDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomCountryDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomLaunchDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomLaunchDetailDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomLaunchPadDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomMissionDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomRocketDTO
import kotlinx.coroutines.flow.Flow

/**
 * This is the Room database access object for the launches table.
 */
@Dao
@Suppress("TooManyFunctions")
interface RoomLaunchDao : BaseAgencyDao {
    @Upsert
    suspend fun upsertLaunches(
        launches: List<RoomLaunchDTO>,
    )

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreMission(
        mission: RoomMissionDTO,
    )

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreRocket(
        rocket: RoomRocketDTO,
    )

    @Upsert
    suspend fun upsertLaunchPad(
        launchPad: RoomLaunchPadDTO,
    )

    private suspend fun insertDomainRocket(
        rocket: Rocket,
    ) {
        val manufacturer = rocket.manufacturer
        if (manufacturer != null) {
            upsertDomainAgency(manufacturer)
        }

        val rocketDto = RoomRocketDTO(rocket)
        insertOrIgnoreRocket(rocketDto)
    }

    suspend fun insertDomainLaunches(
        launches: List<Launch>,
    ) {
        launches.forEach { launch ->
            val padDto = launch.pad?.let(::RoomLaunchPadDTO)
            if (padDto != null) {
                upsertLaunchPad(padDto)
            }

            val agency = launch.agency
            if (agency != null) {
                upsertDomainAgency(agency)
            }

            val missionDto = launch.mission?.let(::RoomMissionDTO)
            if (missionDto != null) {
                insertOrIgnoreMission(missionDto)
            }

            val rocket = launch.rocket
            if (rocket != null) {
                insertDomainRocket(rocket)
            }

            val launchDto = RoomLaunchDTO(launch)
            upsertLaunches(listOf(launchDto))
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
