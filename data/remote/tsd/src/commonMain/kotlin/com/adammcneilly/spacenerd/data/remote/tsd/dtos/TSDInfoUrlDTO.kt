package com.adammcneilly.spacenerd.data.remote.tsd.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TSDInfoUrlDTO(
    @SerialName(value = "description")
    val description: String? = null,
    @SerialName(value = "feature_image")
    val featureImage: TSDImageDTO? = null,
    @SerialName(value = "language")
    val language: TSDLanguageDTO? = null,
    @SerialName(value = "priority")
    val priority: Int? = null,
    @SerialName(value = "source")
    val source: String? = null,
    @SerialName(value = "title")
    val title: String? = null,
    @SerialName(value = "type")
    val type: TSDTypeDTO? = null,
    @SerialName(value = "url")
    val url: String? = null,
)
