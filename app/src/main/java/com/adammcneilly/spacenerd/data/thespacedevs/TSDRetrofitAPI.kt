package com.adammcneilly.spacenerd.data.thespacedevs

import com.adammcneilly.spacenerd.data.thespacedevs.dto.TSDLaunchDTO
import com.adammcneilly.spacenerd.data.thespacedevs.dto.TSDLaunchListResponseDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TSDRetrofitAPI {
    @GET("2.3.0/launches")
    suspend fun getLaunches(
        @Query("slug") slug: String?,
        @Query("net__gte") after: String?,
        @Query("net__lte") before: String?,
    ): TSDLaunchListResponseDTO

    @GET("2.3.0/launches/{id}")
    suspend fun getLaunch(
        @Path("id") id: String,
    ): TSDLaunchDTO

    @GET("2.3.0/launches/upcoming")
    suspend fun getUpcomingLaunches(): TSDLaunchListResponseDTO
}
