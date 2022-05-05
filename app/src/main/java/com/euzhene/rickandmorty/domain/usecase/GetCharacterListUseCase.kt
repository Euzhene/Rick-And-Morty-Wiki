package com.euzhene.rickandmorty.domain.usecase

import androidx.paging.PagingData
import com.euzhene.rickandmorty.domain.model.Character
import com.euzhene.rickandmorty.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharacterListUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    operator fun  invoke(): Flow<PagingData<Character>> {
        return repository.getCharacters()
    }
}