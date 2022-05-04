package com.euzhene.rickandmorty.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.euzhene.rickandmorty.data.mapper.CharacterMapper
import com.euzhene.rickandmorty.data.network.CharacterService
import java.lang.RuntimeException
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class ViewModelFactory @Inject constructor(
    private val apiService: CharacterService,
    private val mapper: CharacterMapper,
):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass == CharacterViewModel::class.java) {
            return CharacterViewModel(apiService, mapper) as T
        }
        throw RuntimeException("Unknown view model $modelClass")
    }
}