package com.adammcneilly.spacenerd.di

import com.adammcneilly.spacenerd.data.spaceflightnews.SpaceFlightNewsRetrofitAPI
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {
    private const val SPACE_FLIGHT_NEWS_API_URL = "https://api.spaceflightnewsapi.net/"

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(loggingInterceptor)
            .build()

    @Provides
    @Singleton
    @Named("SpaceFlightNewsRetrofit")
    fun provideSpaceFlightNewsRetrofit(
        okHttpClient: OkHttpClient,
    ): Retrofit =
        Retrofit
            .Builder()
            .baseUrl(SPACE_FLIGHT_NEWS_API_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().build()))
            .build()

    @Provides
    @Singleton
    fun provideSpaceFlightNewsRetrofitAPI(
        @Named("SpaceFlightNewsRetrofit")
        retrofit: Retrofit,
    ): SpaceFlightNewsRetrofitAPI = retrofit.create(SpaceFlightNewsRetrofitAPI::class.java)
}
