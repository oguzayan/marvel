package com.ayanoguz.marvel.ui.characterDetail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ayanoguz.marvel.data.interactor.characterDetail.CharacterDetailInteractor
import com.ayanoguz.marvel.testUtil.MockData
import com.ayanoguz.marvel.testUtil.getOrAwaitValue
import com.ayanoguz.marvel.util.UIState
import io.mockk.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.io.IOException

@ExperimentalCoroutinesApi
class CharacterDetailViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = TestCoroutineDispatcher()
    private val testScope = TestCoroutineScope(testDispatcher)

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        testDispatcher.cleanupTestCoroutines()
        clearAllMocks()
    }

    @Test
    fun test_getCharacterDetail_Success() = testScope.runBlockingTest {
        val interactor = mockk<CharacterDetailInteractor>()
        coEvery { interactor.getCharacterDetail(1, 0, "","") } returns UIState.Data(MockData.characterDetailUIModel)

        val viewModel = CharacterDetailViewModel(interactor)
        viewModel.getCharacterDetail(1, 0, "","")

        val data = viewModel.liveComicsResult.getOrAwaitValue(latchCount = 2)
        assert(data is UIState.Data)
        assert((data as UIState.Data).data == MockData.characterDetailUIModel)
    }

    @Test
    fun test_getCharacterDetail_Fail() = testScope.runBlockingTest {
        val interactor = mockk<CharacterDetailInteractor>()
        val errorResponse = IOException("Failed to connect to network!")
        coEvery { interactor.getCharacterDetail(1, 0, "","") } returns UIState.Error(errorResponse)
        val viewModel = CharacterDetailViewModel(interactor)
        viewModel.getCharacterDetail(1, 0, "","")

        val data = viewModel.liveComicsResult.getOrAwaitValue(latchCount = 2)
        assert(data is UIState.Error)
    }
}