package com.example.fm2022task.randomWord

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class WordService {

    private val repository = Retrofit.Builder()
        .baseUrl("https://random-words-api.vercel.app/")
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(WordInterface::class.java)

    suspend fun getWord(): WordModel {
        return repository.getWord()[0]
    }

}


