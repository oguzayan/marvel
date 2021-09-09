package com.ayanoguz.marvel.ui.characterDetail

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ayanoguz.marvel.core.BaseViewModel
import com.ayanoguz.marvel.data.interactor.characterDetail.CharacterDetailInteractor
import com.ayanoguz.marvel.data.interactor.characterDetail.ComicsUIModel
import com.ayanoguz.marvel.data.interactor.characterList.CharacterUIModel
import com.ayanoguz.marvel.util.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val characterDetailInteractor: CharacterDetailInteractor

) : BaseViewModel() {

    val liveComicsResult: LiveData<UIState<List<ComicsUIModel>>>
        get() = _liveCharacterDetailResult
    private val _liveCharacterDetailResult =
        MutableLiveData<UIState<List<ComicsUIModel>>>(UIState.Loading)

    val characterItem = ObservableField<CharacterUIModel>()
    val showEmptyView = ObservableField(false)

    fun getCharacterDetail(id: Int, limit: Int, dateRange: String, orderBy: String) {
        viewModelScope.launch {
            characterDetailInteractor.getCharacterDetail(id, limit, dateRange, orderBy).let {
                _liveCharacterDetailResult.postValue(it)
            }
        }
    }

}