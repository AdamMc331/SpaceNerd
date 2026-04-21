package com.adammcneilly.spacenerd.data.local.room.dtos

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(
    tableName = "agency_country_cross_ref",
    primaryKeys = [
        "agency_id",
        "country_id",
    ],
)
data class RoomAgencyCountryCrossRefDTO(
    @ColumnInfo(name = "agency_id") val agencyId: String,
    @ColumnInfo(name = "country_id") val countryId: String,
)
