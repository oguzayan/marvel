package com.ayanoguz.marvel.ui.characterList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.ayanoguz.marvel.core.BaseViewModel
import com.ayanoguz.marvel.data.interactor.characterList.CharacterInteractor
import com.ayanoguz.marvel.data.interactor.characterList.CharacterUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    private val characterInteractor: CharacterInteractor
) : BaseViewModel() {
    val pageSize = 30

    val liveCharacterResult: LiveData<PagingData<CharacterUIModel>>
        get() = _liveCharacterResult
    private val _liveCharacterResult =
        MutableLiveData<PagingData<CharacterUIModel>>()


    fun getCharacterList() {
        progressLiveData.postValue(true)

        viewModelScope.launch {
            characterInteractor.getCharacterList(pageSize).cachedIn(viewModelScope).collect {
                _liveCharacterResult.postValue(it)
            }
        }
    }

}