package com.euzhene.rickandmorty.data.mapper

import com.euzhene.rickandmorty.data.network.model.CharacterResponse
import com.euzhene.rickandmorty.presentation.model.Character

class CharacterMapper {
    fun mapDtoToEntity(characterResponse: CharacterResponse): Character =
        Character(
            characterResponse.episode.size,
            characterResponse.gender,
            characterResponse.id,
            characterResponse.image,
            characterResponse.location?.name ?: "",
            characterResponse.name,
            characterResponse.species,
            characterResponse.status,
        )

}