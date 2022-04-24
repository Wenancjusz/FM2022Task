package com.example.fm2022task.randomWord

import retrofit2.http.GET

interface WordInterface {
    @GET("/word/")
    suspend fun getWord():List<WordModel>
}