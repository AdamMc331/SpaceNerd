package com.adammcneilly.spacenerd.shared.di

import com.adammcneilly.spacenerd.shared.data.article.local.LocalArticleService
import com.adammcneilly.spacenerd.shared.data.article.local.room.RoomArticleService
import com.adammcneilly.spacenerd.shared.data.local.room.SpaceNerdDatabase
import com.adammcneilly.spacenerd.shared.data.local.room.getDatabase

object LocalDataDependencies {
    val roomDatabase: SpaceNerdDatabase by lazy {
        getDatabase()
    }

    val localArticleService: LocalArticleService by lazy {
        RoomArticleService(
            articleDao = roomDatabase.articleDao(),
        )
    }
}
