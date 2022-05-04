package com.euzhene.rickandmorty.domain.repository

import androidx.paging.PagingData
import com.euzhene.rickandmorty.domain.model.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun getCharacterInfo(id:Int): Flow<Character>

    fun getCharacters():Flow<PagingData<Character>>
}