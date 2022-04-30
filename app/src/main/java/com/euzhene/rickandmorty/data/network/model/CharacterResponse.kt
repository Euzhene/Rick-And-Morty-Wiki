package com.euzhene.rickandmorty.data.network.model

import com.euzhene.rickandmorty.domain.entity.Character
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharacterResponse(
    val info: Info,
    val results: List<Character>
)