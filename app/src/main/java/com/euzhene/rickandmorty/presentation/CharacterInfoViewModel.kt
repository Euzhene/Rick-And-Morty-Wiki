package com.euzhene.rickandmorty.presentation

import androidx.lifecycle.ViewModel
import com.euzhene.rickandmorty.domain.usecase.GetCharacterInfoUseCase
import javax.inject.Inject

class CharacterInfoViewModel @Inject constructor(
    getCharacterInfoUseCase: GetCharacterInfoUseCase,
    id: Int,
) : ViewModel() {
    val characterInfo = getCharacterInfoUseCase(id)
}