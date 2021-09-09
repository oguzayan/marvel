package com.ayanoguz.marvel.data.interactor.characterDetail

import com.ayanoguz.marvel.data.repository.CharacterDetailRepository
import com.ayanoguz.marvel.testUtil.MockData
import com.ayanoguz.marvel.util.Result
import com.ayanoguz.marvel.util.UIState
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
class CharacterDetailInteractorTest {
    private val repository = mockk<CharacterDetailRepository>()
    private val mapper = CharacterDetailUIMapper()

    private val interactor = CharacterDetailInteractor(repository, mapper)

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun test_getCharacterDetail_Fail() = runBlockingTest {
        val errorResponse = IOException("Failed to connect to network!")

        coEvery { repository.getCharacterDetail(1, 0, "", "") } returns Result.Failure(errorResponse)

        val characterDetail = interactor.getCharacterDetail(1, 0, "", "")

        assert(characterDetail is UIState.Error)
    }

    @Test
    fun test_getCharacterDetail_Success() = runBlockingTest {
        coEvery { repository.getCharacterDetail(1, 0, "", "") } returns Result.Success(MockData.characterDetailResponse)

        val characterDetail = interactor.getCharacterDetail(1, 0, "", "")

        assert(characterDetail is UIState.Data)
        assertEquals((characterDetail as UIState.Data).data, MockData.characterDetailUIModel)
    }
}