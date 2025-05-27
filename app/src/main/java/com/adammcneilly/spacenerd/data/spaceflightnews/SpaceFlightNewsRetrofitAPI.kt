package com.adammcneilly.spacenerd.data.spaceflightnews

import com.adammcneilly.spacenerd.data.spaceflightnews.dto.SpaceFlightNewsArticleListResponseDTO
import retrofit2.http.GET

interface SpaceFlightNewsRetrofitAPI {
    @GET("v4/articles")
    suspend fun getArticles(): SpaceFlightNewsArticleListResponseDTO
}
