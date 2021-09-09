package com.ayanoguz.marvel.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ayanoguz.marvel.data.interactor.characterList.CharacterUIMapper
import com.ayanoguz.marvel.data.interactor.characterList.CharacterUIModel
import com.ayanoguz.marvel.util.Result
import javax.inject.Inject

class CharacterListPagingSource @Inject constructor(
    private val repo: CharacterRepository,
    private val mapper: CharacterUIMapper
) : PagingSource<Int, CharacterUIModel>() {

    override fun getRefreshKey(state: PagingState<Int, CharacterUIModel>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterUIModel> {
        val page = params.key ?: 0
        return when (val getCharacterList =
            repo.getCharacterList(
                limit = params.loadSize,
                offset = page.times(params.loadSize)
            )) {
            is Result.Success -> LoadResult.Page(
                data = mapper.map(getCharacterList.data),
                nextKey = page.plus(1),
                prevKey = if (page > 0) page.minus(1) else null
            )
            is Result.Failure -> LoadResult.Error(getCharacterList.error)
        }
    }
}