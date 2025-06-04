package com.adammcneilly.spacenerd.core.displaymodels

import com.adammcneilly.spacenerd.core.models.Author

data class AuthorDisplayModel(
    val name: String,
) {
    constructor(
        author: Author,
    ) : this(
        name = author.name,
    )
}
