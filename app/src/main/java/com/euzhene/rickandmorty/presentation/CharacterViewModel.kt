package com.euzhene.rickandmorty.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.euzhene.rickandmorty.data.mapper.CharacterMapper
import com.euzhene.rickandmorty.data.CharacterPageSource
import com.euzhene.rickandmorty.data.network.CharacterService
import kotlinx.coroutines.flow.Flow
import com.euzhene.rickandmorty.domain.model.Character

class CharacterViewModel(
    private val apiService: CharacterService,
    private val mapper: CharacterMapper
) : ViewModel() {
    val charactersFlow: Flow<PagingData<Character>> = Pager(
        config = PagingConfig(
            pageSize = 20,
            initialLoadSize = 20,
            prefetchDistance = 15,
        ),
        pagingSourceFactory = { CharacterPageSource(apiService, mapper) }
    ).flow
        .cachedIn(viewModelScope)
}