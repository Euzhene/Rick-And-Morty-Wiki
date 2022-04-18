package com.euzhene.rickandmorty.data.network

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.euzhene.rickandmorty.data.network.model.CharacterResponse
import com.euzhene.rickandmorty.domain.entity.Character
import retrofit2.HttpException
import java.io.IOException

class CharacterPageSource(
    private val characterService: CharacterService,
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
            val characterResponse = response.body() as CharacterResponse

            val characters = characterResponse.results

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