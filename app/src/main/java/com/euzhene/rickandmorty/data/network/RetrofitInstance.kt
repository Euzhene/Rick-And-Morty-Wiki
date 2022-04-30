package com.euzhene.rickandmorty.data.network

import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


object RetrofitInstance {
    private val moshi by lazy {
        Moshi.Builder().build()
    }
    val api: CharacterService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(CharacterService::class.java)
    }
    private const val BASE_URL = "https://rickandmortyapi.com/api/"
}