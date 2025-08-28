package com.adammcneilly.spacenerd.data.stations.impl.local

import com.adammcneilly.spacenerd.core.models.SpaceStation
import com.adammcneilly.spacenerd.data.local.room.daos.RoomSpaceStationDao
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomSpaceStationAgencyCrossRefDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomSpaceStationDTO
import com.adammcneilly.spacenerd.data.local.room.dtos.RoomSpaceStationDetailDTO
import com.adammcneilly.spacenerd.data.stations.api.SpaceStationListRequest
import com.adammcneilly.spacenerd.data.stations.api.local.LocalSpaceStationService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * This is an implementation of [LocalSpaceStationService] that requests data from a local Room [spaceStationDao].
 */
class RoomSpaceStationService(
    private val spaceStationDao: RoomSpaceStationDao,
) : LocalSpaceStationService {
    override suspend fun saveStations(
        stations: List<SpaceStation>,
        replace: Boolean,
    ) {
        val stationsToAgencies = stations.map { station ->
            station.agencies.map { agency ->
                RoomSpaceStationAgencyCrossRefDTO(
                    spaceStationId = station.id,
                    agencyId = agency.id,
                )
            }
        }

        for (stationAgencies in stationsToAgencies) {
            spaceStationDao.insertStationAgencyMap(stationAgencies)
        }

        val stationDtos = stations.map(::RoomSpaceStationDTO)

        if (replace) {
            spaceStationDao.insertOrReplaceSpaceStations(stationDtos)
        } else {
            spaceStationDao.insertOrIgnoreSpaceStations(stationDtos)
        }
    }

    override fun getStations(
        request: SpaceStationListRequest,
    ): Flow<List<SpaceStation>> {
        return spaceStationDao.getSpaceStations(
            status = request.status,
        ).map { stationDtos ->
            stationDtos.map(RoomSpaceStationDTO::toSpaceStation)
        }
    }

    override fun getStation(
        id: String,
    ): Flow<SpaceStation> {
        return spaceStationDao
            .getSpaceStation(id)
            .map(RoomSpaceStationDetailDTO::toSpaceStation)
    }
}
