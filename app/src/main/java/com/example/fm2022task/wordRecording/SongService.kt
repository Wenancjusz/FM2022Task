package com.example.fm2022task.wordRecording

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SongService {


    val logging = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    var gson = GsonBuilder()
        .setLenient()
        .create()

    private val repository = Retrofit.Builder()
        .baseUrl("https://musicbrainz.org/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(client)
        .build().create(SongInterface::class.java)

    suspend fun getSong(query: String): SongModel? {
        return repository.getSong(query).recordings.firstOrNull()
    }

}