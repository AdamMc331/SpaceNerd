package com.adammcneilly.spacenerd.data.local.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.adammcneilly.spacenerd.core.models.Launch
import com.adammcneilly.spacenerd.core.models.LaunchCrewMember
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomAgencyDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomAstronautDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomAstronautRoleDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomLaunchCrewMemberDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomLaunchDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomLaunchDetailDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomLaunchPadDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomMissionDTO
import kotlinx.coroutines.flow.Flow

/**
 * This is the Room database access object for the launches table.
 */
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

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreMission(
        mission: RoomMissionDTO,
    )

    @Upsert
    suspend fun upsertAstronautRole(
        role: RoomAstronautRoleDTO,
    )

    @Upsert
    suspend fun upsertAstronaut(
        astronaut: RoomAstronautDTO,
    )

    @Upsert
    suspend fun upsertLaunchCrewMember(
        launchCrewMember: RoomLaunchCrewMemberDTO,
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

            val missionDto = launch.mission?.let(::RoomMissionDTO)
            if (missionDto != null) {
                insertOrIgnoreMission(missionDto)
            }

            launch.crew?.forEach { crewMember ->
                insertLaunchCrewMember(crewMember)
            }

            val launchDto = RoomLaunchDTO(launch)
            insertLaunches(listOf(launchDto))
        }
    }

    private suspend fun insertLaunchCrewMember(
        launchCrewMember: LaunchCrewMember,
    ) {
        val roleDto = RoomAstronautRoleDTO(launchCrewMember.role)
        upsertAstronautRole(roleDto)

        val astronautDto = RoomAstronautDTO(launchCrewMember.astronaut)
        upsertAstronaut(astronautDto)

        val launchCrewMemberDto = RoomLaunchCrewMemberDTO(launchCrewMember)
        upsertLaunchCrewMember(launchCrewMemberDto)
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
