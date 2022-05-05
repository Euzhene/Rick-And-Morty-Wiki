package com.euzhene.rickandmorty.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.euzhene.rickandmorty.domain.usecase.GetCharacterListUseCase
import javax.inject.Inject

class CharacterListViewModel @Inject constructor(
    getCharactersUseCase: GetCharacterListUseCase,
    id:Int,
) : ViewModel() {
    val charactersList = getCharactersUseCase().cachedIn(viewModelScope)
}