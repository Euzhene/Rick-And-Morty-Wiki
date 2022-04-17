package com.euzhene.rickandmorty.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.euzhene.rickandmorty.data.network.CharacterPageSource
import com.euzhene.rickandmorty.data.network.RetrofitInstance
import com.euzhene.rickandmorty.domain.entity.Character
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CharacterViewModel() : ViewModel() {
    private val retrofitApi = RetrofitInstance.api
    val charactersFlow: Flow<PagingData<Character>> = Pager(
        config = PagingConfig(pageSize = 20, initialLoadSize = 20),
        pagingSourceFactory = { CharacterPageSource(retrofitApi) }
    ).flow
        .cachedIn(viewModelScope)
}