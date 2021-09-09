package com.ayanoguz.marvel.data.interactor.characterList

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.ayanoguz.marvel.data.repository.CharacterListPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharacterInteractor @Inject constructor(
    private val source: CharacterListPagingSource,
) {

    fun getCharacterList(limit: Int): Flow<PagingData<CharacterUIModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = limit,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                source
            }
        ).flow
    }

}