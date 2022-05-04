package com.euzhene.rickandmorty.data.network

import com.euzhene.rickandmorty.data.network.dto.CharacterDto
import com.euzhene.rickandmorty.data.network.dto.GetResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterService {

    @GET("character")
    suspend fun getCharacters(@Query("page") page: Int): Response<GetResponseDto>

    @GET("character/")
    suspend fun getCharacter(@Query("id") id:Int):Response<CharacterDto>
}