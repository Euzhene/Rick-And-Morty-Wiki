package com.euzhene.rickandmorty.data.repository

import androidx.paging.PagingData
import com.euzhene.rickandmorty.data.dataSource.CharacterRemoteDataSource
import com.euzhene.rickandmorty.data.mapper.CharacterMapper
import com.euzhene.rickandmorty.data.network.CharacterService
import com.euzhene.rickandmorty.domain.model.Character
import com.euzhene.rickandmorty.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.RuntimeException
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor (
    private val mapper: CharacterMapper,
    private val characterService: CharacterService,
    private val remoteDataSource: CharacterRemoteDataSource
) : CharacterRepository {
    override fun getCharacterInfo(id: Int): Flow<Character> {
        return flow {
            val response = characterService.getCharacter(id)
            if (response.isSuccessful) {
                val characterDao = response.body()!!
                val character = mapper.mapDtoToEntity(characterDao)
                emit(character)
            } else {
                throw RuntimeException("Response is unsuccessful " +
                        "due to reason ${response.errorBody()}")
            }
        }
    }

    override fun getCharacters(): Flow<PagingData<Character>> {
       return remoteDataSource.getCharacters()
    }
}