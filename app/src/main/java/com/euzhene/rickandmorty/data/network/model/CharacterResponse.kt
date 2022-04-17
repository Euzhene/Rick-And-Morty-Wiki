package com.euzhene.rickandmorty.data.network.model

import com.euzhene.rickandmorty.domain.entity.Character

data class CharacterResponse(
    val info: Info,
    val results: List<Character>
)