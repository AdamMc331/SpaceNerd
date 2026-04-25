package com.adammcneilly.spacenerd.data.local.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.adammcneilly.spacenerd.core.models.CrewMember
import com.adammcneilly.spacenerd.core.models.Expedition
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomAstronautDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomAstronautRoleDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomCrewMemberDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomExpeditionDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomExpeditionWithCrewDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomSpaceStationDTO
import kotlinx.coroutines.flow.Flow
import kotlin.math.exp

@Dao
interface RoomExpeditionDao : BaseSpaceStationDao {
    @Upsert
    suspend fun upsertExpedition(
        expeditions: RoomExpeditionDTO,
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
    suspend fun upsertCrewMember(
        launchCrewMember: RoomCrewMemberDTO,
    )

    suspend fun upsertDomainExpeditions(
        expeditions: List<Expedition>,
    ) {
        expeditions.forEach { expedition ->
            val spaceStation = expedition.spaceStation
            if (spaceStation != null) {
                insertOrIgnoreDomainSpaceStation(spaceStation)
            }

            expedition.crew.forEach { crewMember ->
                insertCrewMember(
                    crewMember = crewMember,
                    expeditionId = expedition.id,
                )
            }

            val expeditionDto = RoomExpeditionDTO(expedition)
            upsertExpedition(expeditionDto)
        }
    }

    private suspend fun insertCrewMember(
        crewMember: CrewMember,
        expeditionId: String,
    ) {
        val roleDto = RoomAstronautRoleDTO(crewMember.role)
        upsertAstronautRole(roleDto)

        val astronautDto = RoomAstronautDTO(crewMember.astronaut)
        upsertAstronaut(astronautDto)

        val crewMemberDto = RoomCrewMemberDTO(
            crewMember = crewMember,
            expeditionId = expeditionId,
        )

        upsertCrewMember(crewMemberDto)
    }

    @Transaction
    @Query(
        """
            SELECT *
            FROM expeditions
            WHERE 
                (:spaceStationId IS NULL OR spaceStationId == :spaceStationId)
                AND expeditionStart <= :now
                AND expeditionEnd IS NULL
        """,
    )
    fun getActiveExpeditions(
        spaceStationId: String?,
        now: String,
    ): Flow<List<RoomExpeditionWithCrewDTO>>

    @Transaction
    @Query(
        """
            SELECT * 
            FROM expeditions
            WHERE (:spaceStationId IS NULL OR spaceStationId == :spaceStationId)
        """,
    )
    fun getExpeditions(
        spaceStationId: String?,
    ): Flow<List<RoomExpeditionWithCrewDTO>>
}
