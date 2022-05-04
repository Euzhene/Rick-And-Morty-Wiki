package com.euzhene.rickandmorty.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.euzhene.rickandmorty.domain.usecase.GetCharacterListUseCase

class CharacterListViewModel(
    getCharactersUseCase:GetCharacterListUseCase
) : ViewModel() {
    val charactersList = getCharactersUseCase().cachedIn(viewModelScope)
}