package com.adammcneilly.spacenerd.core.displaymodels

import com.adammcneilly.spacenerd.core.models.Country

data class CountryDisplayModel(
    val id: String,
    val name: String,
    val alpha3Code: String,
    val placeholder: Boolean = false,
) {
    constructor(
        country: Country,
    ) : this(
        id = country.id,
        name = country.name,
        alpha3Code = country.alpha3Code,
    )

    companion object {
        fun placeholder(): CountryDisplayModel {
            return CountryDisplayModel(
                id = "123",
                name = "Placeholder Country",
                alpha3Code = "PLC",
                placeholder = true,
            )
        }
    }
}
