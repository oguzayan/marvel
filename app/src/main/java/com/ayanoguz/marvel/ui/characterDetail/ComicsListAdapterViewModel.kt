package com.ayanoguz.marvel.ui.characterDetail

import androidx.databinding.ObservableField
import com.ayanoguz.marvel.core.BaseViewModel
import com.ayanoguz.marvel.data.interactor.characterDetail.ComicsUIModel
import javax.inject.Inject

class ComicsListAdapterViewModel @Inject constructor() : BaseViewModel() {

    val item = ObservableField<ComicsUIModel>()
}