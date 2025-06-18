package com.adammcneilly.spacenerd.shared.data.article.remote.snapi.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SNAPILaunchDTO(
    @SerialName(value = "launch_id")
    val launchId: String? = null,
    @SerialName(value = "provider")
    val provider: String? = null,
)
