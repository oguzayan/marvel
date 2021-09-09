package com.ayanoguz.marvel.data.repository

import com.ayanoguz.marvel.data.datasource.RemoteDataSource
import com.ayanoguz.marvel.testUtil.MockData
import com.ayanoguz.marvel.util.Result
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import okio.IOException
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Test

@ExperimentalCoroutinesApi
class CharacterRepositoryTest {
    private val dataSource = mockk<RemoteDataSource>()
    private val repository = CharacterRepositoryImpl(dataSource)

    private val page = 0
    private val limit = 30

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun test_getCharacterList_Fail() = runBlockingTest {
        val errorResponse = IOException("Failed to connect to network!")

        coEvery { repository.getCharacterList(limit, page) } returns Result.Failure(errorResponse)

        val characters = dataSource.getCharacterList(limit, page)

        assert(characters is Result.Failure)
    }

    @Test
    fun test_getCharacterList_Success() = runBlockingTest {
        coEvery {
            repository.getCharacterList(
                limit,
                page
            )
        } returns Result.Success(MockData.characterListResponse)

        val characters = dataSource.getCharacterList(limit, page)

        assert(characters is Result.Success)
        assertEquals((characters as Result.Success).data, MockData.characterListResponse)
    }
}