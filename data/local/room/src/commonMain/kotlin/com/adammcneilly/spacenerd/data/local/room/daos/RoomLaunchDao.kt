package com.adammcneilly.spacenerd.data.local.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
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
interface RoomLaunchDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLaunches(
        launches: List<RoomLaunchDTO>,
    )

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreAgency(
        agency: RoomAgencyDTO,
    )

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreCountry(
        country: RoomCountryDTO,
    )

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreAgencyCountryCrossRef(
        crossRef: RoomAgencyCountryCrossRefDTO,
    )

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreMission(
        mission: RoomMissionDTO,
    )

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreRocket(
        rocket: RoomRocketDTO,
    )

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLaunchPad(
        launchPad: RoomLaunchPadDTO,
    )

    /**
     * NOTE: Cleanup opportunity - when we insert the manufacturer, we're not inserting the country.
     * Maybe we can find a way to consolidate across DAOs.
     */
    private suspend fun insertDomainRocket(
        rocket: Rocket,
    ) {
        val manufacturerDto = rocket.manufacturer?.let(::RoomAgencyDTO)
        if (manufacturerDto != null) {
            insertOrIgnoreAgency(manufacturerDto)
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
                insertLaunchPad(padDto)
            }

            val agencyDto = launch.agency?.let(::RoomAgencyDTO)
            if (agencyDto != null) {
                insertOrIgnoreAgency(agencyDto)

                val countryDtos = launch.agency?.countries?.map(::RoomCountryDTO)

                countryDtos?.forEach { countryDto ->
                    insertOrIgnoreCountry(countryDto)

                    val crossRef = RoomAgencyCountryCrossRefDTO(
                        agencyId = agencyDto.agencyId,
                        countryId = countryDto.countryId,
                    )

                    insertOrIgnoreAgencyCountryCrossRef(crossRef)
                }
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
