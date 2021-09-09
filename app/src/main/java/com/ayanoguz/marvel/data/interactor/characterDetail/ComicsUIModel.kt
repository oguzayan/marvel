package com.ayanoguz.marvel.data.interactor.characterDetail

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ComicsUIModel(
    val id: Int?,
    val name: String?,
    val image: String?,
    val year: String?,
    val description: String?
) : Parcelable