package com.adammcneilly.spacenerd.data.local.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Transaction
import androidx.room.Upsert
import com.adammcneilly.spacenerd.core.models.Agency
import com.adammcneilly.spacenerd.core.models.SpaceStation
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomSpaceStationAgencyCrossRefDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomSpaceStationDTO

@Dao
interface BaseSpaceStationDao : BaseAgencyDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreSpaceStation(
        station: RoomSpaceStationDTO,
    )

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertSpaceStationAgencyCrossRef(
        stationAgencyCrossRefDTO: RoomSpaceStationAgencyCrossRefDTO,
    )

    @Upsert
    suspend fun upsertSpaceStation(
        station: RoomSpaceStationDTO,
    )

    private suspend fun insertSpaceStationAgencies(
        station: SpaceStation,
    ) {
        for (agency in station.agencies) {
            upsertDomainAgency(agency)

            val crossRef = RoomSpaceStationAgencyCrossRefDTO(
                spaceStationId = station.id,
                agencyId = agency.id,
            )

            insertSpaceStationAgencyCrossRef(crossRef)
        }
    }

    @Transaction
    suspend fun upsertDomainSpaceStation(
        station: SpaceStation,
    ) {
        insertSpaceStationAgencies(station)

        val stationDto = RoomSpaceStationDTO(station)
        upsertSpaceStation(stationDto)
    }

    @Transaction
    suspend fun insertOrIgnoreDomainSpaceStation(
        station: SpaceStation,
    ) {
        insertSpaceStationAgencies(station)

        val stationDto = RoomSpaceStationDTO(station)
        insertOrIgnoreSpaceStation(stationDto)
    }
}
