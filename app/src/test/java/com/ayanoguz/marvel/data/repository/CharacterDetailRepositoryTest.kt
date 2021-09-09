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
import org.junit.Assert
import org.junit.Test

@ExperimentalCoroutinesApi
class CharacterDetailRepositoryTest {
    private val dataSource = mockk<RemoteDataSource>()
    private val repository = CharacterDetailRepositoryImpl(dataSource)

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun test_getCharacterList_Fail() = runBlockingTest {
        val errorResponse = IOException("Failed to connect to network!")

        coEvery {
            repository.getCharacterDetail(
                1,
                0,
                "",
                ""
            )
        } returns Result.Failure(errorResponse)

        val characters = dataSource.getCharacterDetail(1, 0, "", "")

        assert(characters is Result.Failure)
    }

    @Test
    fun test_getCharacterList_Success() = runBlockingTest {
        coEvery {
            repository.getCharacterDetail(
                1,
                0,
                "",
                ""
            )
        } returns Result.Success(MockData.characterDetailResponse)

        val characters = dataSource.getCharacterDetail(1, 0, "", "")

        assert(characters is Result.Success)
        Assert.assertEquals((characters as Result.Success).data, MockData.characterDetailResponse)
    }
}