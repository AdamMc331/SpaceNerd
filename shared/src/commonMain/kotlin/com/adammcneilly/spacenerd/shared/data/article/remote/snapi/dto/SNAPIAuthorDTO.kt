package com.adammcneilly.spacenerd.shared.data.article.remote.snapi.dto

import com.adammcneilly.spacenerd.core.models.Author
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SNAPIAuthorDTO(
    @SerialName(value = "name")
    val name: String? = null,
    @SerialName(value = "socials")
    val socials: SNAPISocialsDTO? = null,
) {
    fun toAuthor(): Author {
        return Author(
            name = this.name.orEmpty(),
        )
    }
}
