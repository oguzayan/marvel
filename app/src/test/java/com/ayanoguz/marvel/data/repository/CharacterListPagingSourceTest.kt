package com.ayanoguz.marvel.data.repository

import androidx.paging.PagingSource
import com.ayanoguz.marvel.data.interactor.characterList.CharacterUIMapper
import com.ayanoguz.marvel.data.interactor.characterList.CharacterUIMapperTest
import com.ayanoguz.marvel.data.interactor.characterList.CharacterUIModel
import com.ayanoguz.marvel.testUtil.MockData
import com.ayanoguz.marvel.util.Result
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import okio.IOException
import org.junit.Assert
import org.junit.Test

@ExperimentalCoroutinesApi
class CharacterListPagingSourceTest {

    val repo = mockk<CharacterRepository>()
    val mapper = CharacterUIMapper()

    val pagingSource = CharacterListPagingSource(repo, mapper)

    @Test
    fun test_getCharacterList_Fail() = runBlockingTest {
        val errorResponse = IOException("Failed to connect to network!")
        coEvery { repo.getCharacterList(any(), any()) } returns Result.Failure(errorResponse)

        Assert.assertEquals(
            PagingSource.LoadResult.Error<Int, CharacterUIModel>(errorResponse),
            pagingSource.load(
                PagingSource.LoadParams.Refresh(
                    key = null,
                    loadSize = 2,
                    placeholdersEnabled = false
                )
            )
        )
    }

    @Test
    fun test_getCharacterList_Success() = runBlockingTest {
        coEvery { repo.getCharacterList(any(), any()) } returns Result.Success(MockData.characterListResponse)

        Assert.assertEquals(
            PagingSource.LoadResult.Page(
                data = MockData.characterListUIModel,
                prevKey = null,
                nextKey = 1
            ),
            pagingSource.load(
                PagingSource.LoadParams.Refresh(
                    key = null,
                    loadSize = 5,
                    placeholdersEnabled = false
                )
            )
        )
    }
}