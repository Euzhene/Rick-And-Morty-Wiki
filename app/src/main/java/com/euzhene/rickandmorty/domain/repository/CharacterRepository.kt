package com.euzhene.rickandmorty.domain.repository

import com.euzhene.rickandmorty.domain.model.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun getCharacter(id:Int): Flow<Character>
}