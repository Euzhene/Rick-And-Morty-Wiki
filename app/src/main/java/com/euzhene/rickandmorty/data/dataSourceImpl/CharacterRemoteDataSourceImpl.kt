package com.euzhene.rickandmorty.data.dataSourceImpl

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.euzhene.rickandmorty.data.dataSource.CharacterRemoteDataSource
import com.euzhene.rickandmorty.data.mapper.CharacterMapper
import com.euzhene.rickandmorty.data.network.CharacterService
import com.euzhene.rickandmorty.data.paging.CharacterPageSource
import com.euzhene.rickandmorty.domain.model.Character
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharacterRemoteDataSourceImpl @Inject constructor(
    private val apiService: CharacterService,
    private val mapper: CharacterMapper,
):CharacterRemoteDataSource {
    override fun getCharacters(): Flow<PagingData<Character>> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                initialLoadSize = INITIAL_LOAD_SIZE,
                prefetchDistance = PREFETCH_DISTANCE,
            ),
            pagingSourceFactory = { CharacterPageSource(apiService, mapper) }
        ).flow
    }

    companion object {
        private const val PAGE_SIZE = 20
        private const val INITIAL_LOAD_SIZE = 20
        private const val PREFETCH_DISTANCE = 15
    }
}