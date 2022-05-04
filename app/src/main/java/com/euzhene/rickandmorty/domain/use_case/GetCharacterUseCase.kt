package com.euzhene.rickandmorty.domain.use_case

import com.euzhene.rickandmorty.domain.repository.CharacterRepository
import com.euzhene.rickandmorty.domain.model.Character
import kotlinx.coroutines.flow.Flow

class GetCharacterUseCase(private val repository: CharacterRepository) {
    operator fun invoke(id: Int): Flow<Character> {
        return repository.getCharacter(id)
    }
}