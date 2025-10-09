package com.adammcneilly.spacenerd.core.displaymodels

import com.adammcneilly.spacenerd.core.designsystem.models.ImageModel
import com.adammcneilly.spacenerd.core.models.Rocket
import kotlinx.datetime.LocalDate
import kotlinx.datetime.format
import kotlinx.datetime.format.MonthNames
import kotlinx.datetime.format.char

private val maidenFlightFormat = LocalDate.Format {
    monthName(MonthNames.ENGLISH_ABBREVIATED)
    char(' ')
    day()
    char(',')
    char(' ')
    year()
}

data class RocketDisplayModel(
    val id: String,
    val name: String,
    val image: ImageModel,
    val manufacturer: AgencyDisplayModel?,
    val description: String,
    val maidenFlight: String,
    val totalLaunches: Int,
    val placeholder: Boolean = false,
) {
    constructor(rocket: Rocket) : this(
        id = rocket.id,
        name = rocket.name,
        image = ImageModel.Remote(rocket.imageUrl),
        manufacturer = rocket.manufacturer?.let { AgencyDisplayModel(it) },
        description = rocket.description,
        maidenFlight = rocket.maidenFlight?.format(maidenFlightFormat) ?: "N/A",
        totalLaunches = rocket.totalLaunches,
    )

    companion object {
        fun placeholder(): RocketDisplayModel {
            return RocketDisplayModel(
                id = "",
                name = "Placeholder Rocket",
                image = ImageModel.Placeholder,
                manufacturer = AgencyDisplayModel.placeholder(),
                description = "Rocket Description",
                maidenFlight = "Jan 01, 0001",
                totalLaunches = 0,
                placeholder = true,
            )
        }
    }
}
