package com.adammcneilly.spacenerd.data.local.room.dtos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.adammcneilly.spacenerd.core.models.Country

@Entity(tableName = "countries")
data class RoomCountryDTO(
    @PrimaryKey val countryId: String,
    val name: String,
    val alpha3Code: String,
) {
    constructor(
        country: Country,
    ) : this(
        countryId = country.id,
        name = country.name,
        alpha3Code = country.alpha3Code,
    )

    fun toCountry(): Country {
        return Country(
            id = this.countryId,
            name = this.name,
            alpha3Code = this.alpha3Code,
        )
    }
}
