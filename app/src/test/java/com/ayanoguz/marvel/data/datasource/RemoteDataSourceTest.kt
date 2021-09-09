package com.ayanoguz.marvel.data.datasource

import com.ayanoguz.marvel.net.MarvelAPI
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
class RemoteDataSourceTest {

    private val service = mockk<MarvelAPI>()
    private val dataSource = RemoteDataSource(service)

    private val page = 0
    private val limit = 30

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun test_getCharacterList_Fail() = runBlockingTest {
        val errorResponse = IOException("Failed to connect to network!")

        coEvery { service.getCharacterList(limit, page) } throws errorResponse

        val characters = dataSource.getCharacterList(limit, page)

        assert(characters is Result.Failure)
    }

    @Test
    fun test_getCharacterList_Success() = runBlockingTest {
        coEvery { service.getCharacterList(limit, page) } returns MockData.characterListResponse

        val characters = dataSource.getCharacterList(limit, page)

        assert(characters is Result.Success)
        assertEquals((characters as Result.Success).data, MockData.characterListResponse)
    }

    @Test
    fun test_getCharacterDetail_Fail() = runBlockingTest {
        val errorResponse = IOException("Failed to connect to network!")

        coEvery { service.getCharacterDetail(1, 10, "", "") } throws errorResponse

        val characters = dataSource.getCharacterDetail(1, 10, "", "")

        assert(characters is Result.Failure)
    }

    @Test
    fun test_getCharacterDetail_Success() = runBlockingTest {
        coEvery { service.getCharacterDetail(1, 10, "", "") } returns MockData.characterDetailResponse

        val characters = dataSource.getCharacterDetail(1, 10, "", "")

        assert(characters is Result.Success)
        assertEquals((characters as Result.Success).data, MockData.characterDetailResponse)
    }
}