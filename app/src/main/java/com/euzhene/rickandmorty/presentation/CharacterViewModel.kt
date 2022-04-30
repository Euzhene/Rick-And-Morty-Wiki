package com.euzhene.rickandmorty.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.euzhene.rickandmorty.data.mapper.CharacterMapper
import com.euzhene.rickandmorty.data.CharacterPageSource
import com.euzhene.rickandmorty.data.network.RetrofitInstance
import kotlinx.coroutines.flow.Flow
import com.euzhene.rickandmorty.presentation.model.Character

class CharacterViewModel : ViewModel() {
    private val retrofitApi = RetrofitInstance.api
    val charactersFlow: Flow<PagingData<Character>> = Pager(
        config = PagingConfig(
            pageSize = 20,
            initialLoadSize = 20,
            prefetchDistance = 15,
        ),
        pagingSourceFactory = { CharacterPageSource(retrofitApi, CharacterMapper()) }
    ).flow
        .cachedIn(viewModelScope)
}