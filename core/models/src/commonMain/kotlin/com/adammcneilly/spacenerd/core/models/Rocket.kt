package com.adammcneilly.spacenerd.core.models

import kotlinx.datetime.LocalDate

data class Rocket(
    val id: String,
    val name: String,
    val imageUrl: String,
    val manufacturer: Agency?,
    val description: String,
    val maidenFlight: LocalDate?,
    val totalLaunches: Int,
)
