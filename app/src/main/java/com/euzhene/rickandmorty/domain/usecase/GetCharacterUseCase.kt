package com.euzhene.rickandmorty.domain.usecase

import com.euzhene.rickandmorty.domain.model.Character
import com.euzhene.rickandmorty.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharacterUseCase @Inject constructor (private val repository: CharacterRepository) {
    operator fun invoke(id: Int): Flow<Character> {
        return repository.getCharacterInfo(id)
    }
}