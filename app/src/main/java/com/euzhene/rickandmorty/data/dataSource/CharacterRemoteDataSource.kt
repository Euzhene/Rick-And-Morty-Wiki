package com.euzhene.rickandmorty.data.dataSource

import androidx.paging.PagingData
import com.euzhene.rickandmorty.domain.model.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRemoteDataSource {
    fun getCharacters(): Flow<PagingData<Character>>
}