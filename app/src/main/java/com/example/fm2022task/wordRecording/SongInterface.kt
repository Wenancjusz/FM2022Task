package com.example.fm2022task.wordRecording
import retrofit2.http.GET

interface SongInterface {
    @GET("/")
    suspend fun getSong():List<SongModel>
}