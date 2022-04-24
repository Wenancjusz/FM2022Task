package com.example.fm2022task.wordRecording

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SongService (url:String){

    var gson = GsonBuilder()
        .setLenient()
        .create()

    private val repository = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build().create(SongInterface::class.java)

    suspend fun getSong(): SongModel {
        return repository.getSong()[0]
    }

}