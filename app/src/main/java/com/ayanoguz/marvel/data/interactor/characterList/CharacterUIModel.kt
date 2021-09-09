package com.ayanoguz.marvel.data.interactor.characterList

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class CharacterUIModel(
    val id: Int?,
    val name: String?,
    val image: String?,
    val description: String?
) : Parcelable