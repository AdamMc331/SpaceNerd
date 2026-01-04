package com.adammcneilly.spacenerd.core.displaymodels

import com.adammcneilly.spacenerd.core.designsystem.models.ImageModel
import com.adammcneilly.spacenerd.core.models.SpaceStation
import com.adammcneilly.spacenerd.core.models.SpaceStationStatus
import kotlinx.datetime.LocalDate
import kotlinx.datetime.format
import kotlinx.datetime.format.MonthNames
import kotlinx.datetime.format.char

private val foundedDateFormat = LocalDate.Format {
    monthName(MonthNames.ENGLISH_ABBREVIATED)
    char(' ')
    day()
    char(',')
    char(' ')
    year()
}

/**
 * A user-friendly representation of a space station.
 *
 * @property[id] A unique identifier for this space station.
 * @property[name] The name of this space station.
 * @property[image] The image for this space station.
 * @property[status] The current status of this space station.
 * @property[isPlaceholder] If true, this display model is just a placeholder and the UI
 * should reflect that.
 */
data class SpaceStationDisplayModel(
    val id: String,
    val name: String,
    val image: ImageModel,
    val status: StatusDisplayModel,
    val subtitle: String,
    val agencies: List<AgencyDisplayModel>,
    val isPlaceholder: Boolean = false,
) {
    constructor(station: SpaceStation) : this(
        id = station.id,
        name = station.name,
        image = ImageModel.Remote(station.imageUrl),
        status = StatusDisplayModel(station.status),
        subtitle = station.founded.let { founded ->
            val formattedDate = founded.format(foundedDateFormat)
            "Founded: $formattedDate"
        },
        agencies = station.agencies.map(::AgencyDisplayModel),
    )

    companion object {
        fun placeholder(): SpaceStationDisplayModel {
            return SpaceStationDisplayModel(
                id = "",
                name = "Placeholder Station",
                image = ImageModel.Placeholder,
                status = StatusDisplayModel(SpaceStationStatus.Unknown),
                subtitle = "Founded: Jan 00, 0000",
                agencies = List(3) {
                    AgencyDisplayModel.placeholder()
                },
                isPlaceholder = true,
            )
        }
    }
}
