package com.ayanoguz.marvel.ui.characterList

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.*
import com.ayanoguz.marvel.data.interactor.characterDetail.CharacterDetailInteractor
import com.ayanoguz.marvel.data.interactor.characterList.CharacterInteractor
import com.ayanoguz.marvel.data.interactor.characterList.CharacterUIModel
import com.ayanoguz.marvel.testUtil.MockData
import com.ayanoguz.marvel.testUtil.MyDiffCallback
import com.ayanoguz.marvel.testUtil.NoopListCallback
import com.ayanoguz.marvel.testUtil.getOrAwaitValue
import com.ayanoguz.marvel.ui.characterDetail.CharacterDetailViewModel
import com.ayanoguz.marvel.util.UIState
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.io.IOException

@ExperimentalCoroutinesApi
class CharacterListViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = TestCoroutineDispatcher()
    private val testScope = TestCoroutineScope(testDispatcher)

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun test_characterList_Success() = testScope.runBlockingTest {
        val interactor = mockk<CharacterInteractor>()
        coEvery { interactor.getCharacterList(30) } returns flow {
            emit(PagingData.from(MockData.characterListUIModel))
        }

        val differ = AsyncPagingDataDiffer(
            diffCallback = MyDiffCallback(),
            updateCallback = NoopListCallback(),
            workerDispatcher = Dispatchers.Main
        )

        val viewModel = CharacterListViewModel(interactor)
        viewModel.getCharacterList()

        val data = viewModel.liveCharacterResult.getOrAwaitValue()

        testScope.launch {
            data?.let { differ.submitData(it) }
        }

        advanceUntilIdle()
        assertEquals(MockData.characterListUIModel, differ.snapshot().items)
    }
}