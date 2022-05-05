package com.euzhene.rickandmorty.data.mapper

import com.euzhene.rickandmorty.data.network.dto.CharacterDto
import com.euzhene.rickandmorty.di.ApplicationScope
import com.euzhene.rickandmorty.domain.model.Character
import javax.inject.Inject

@ApplicationScope
class CharacterMapper @Inject constructor(){
    fun mapDtoToEntity(characterDto: CharacterDto): Character =
        Character(
            characterDto.episode.size,
            characterDto.gender,
            characterDto.id,
            characterDto.image,
            characterDto.location?.name ?: "",
            characterDto.name,
            characterDto.species,
            characterDto.status,
        )
}