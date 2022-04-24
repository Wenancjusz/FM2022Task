package com.example.fm2022task.wordRecording

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface SongInterface {
    @GET("/ws/2/recording/")
    @Headers("User-Agent: anonymous")
    suspend fun getSong(
        @Query("query") query: String,
        @Query("fmt") format: String = "json"
    ): SongResponse
}