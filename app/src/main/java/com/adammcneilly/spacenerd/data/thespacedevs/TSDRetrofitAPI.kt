package com.adammcneilly.spacenerd.data.thespacedevs

import com.adammcneilly.spacenerd.data.thespacedevs.dto.TSDLaunchListResponseDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface TSDRetrofitAPI {
    @GET("2.3.0/launches")
    suspend fun getLaunches(
        @Query("slug") slug: String?,
    ): TSDLaunchListResponseDTO
}
