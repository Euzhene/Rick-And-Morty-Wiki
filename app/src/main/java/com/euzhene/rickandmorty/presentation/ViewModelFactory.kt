package com.euzhene.rickandmorty.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.euzhene.rickandmorty.domain.usecase.GetCharacterListUseCase
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class ViewModelFactory @Inject constructor(
    private val getCharacterListUseCase: GetCharacterListUseCase
):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass == CharacterListViewModel::class.java) {
            return CharacterListViewModel(getCharacterListUseCase) as T
        }
        throw RuntimeException("Unknown view model $modelClass")
    }
}