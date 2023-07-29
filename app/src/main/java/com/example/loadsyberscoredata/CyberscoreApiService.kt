package com.example.loadsyberscoredata

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.cyberscore.live"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface CyberscoreApiService {
    @GET("/api/v1/matches")
    suspend fun getAllData(): CyberscoreData
}

object CyberScoreApi {
    val retrofitService: CyberscoreApiService by lazy {
        retrofit.create(CyberscoreApiService::class.java)
    }
}