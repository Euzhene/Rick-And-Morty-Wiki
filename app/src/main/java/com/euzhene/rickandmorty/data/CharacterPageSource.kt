package com.euzhene.rickandmorty.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.euzhene.rickandmorty.data.mapper.CharacterMapper
import com.euzhene.rickandmorty.data.network.CharacterService
import retrofit2.HttpException
import java.io.IOException
import com.euzhene.rickandmorty.presentation.model.Character


class CharacterPageSource(
    private val characterService: CharacterService,
    private val mapper: CharacterMapper
) : PagingSource<Int, Character>() {
    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        val pageIndex = params.key ?: 1
        val pageSize = params.loadSize

        return try {
            val response = characterService.getCharacters(pageIndex)
            val characterResponse = response.body()!!

            val charactersResponse = characterResponse.results
            val characters = charactersResponse.map {
                mapper.mapDtoToEntity(it)
            }

            val prevKey = if (pageIndex == 1) null else pageIndex - 1
            val nextKey = if (characters.size < pageSize) null else pageIndex + 1
            LoadResult.Page(characters, prevKey, nextKey)
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }
}