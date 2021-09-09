package com.ayanoguz.marvel.core

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

    val progressLiveData: MutableLiveData<Boolean> = MutableLiveData()

}