package com.ayanoguz.marvel.util

sealed class UIState<out T : Any> {
    object Loading : UIState<Nothing>()
    class Error(val error: Throwable) : UIState<Nothing>()
    class Data<out T : Any>(val data: T) : UIState<T>()
}