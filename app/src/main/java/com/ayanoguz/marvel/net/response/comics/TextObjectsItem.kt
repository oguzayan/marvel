package com.ayanoguz.marvel.net.response.comics

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TextObjectsItem(

	@Json(name="language")
	val language: String? = null,

	@Json(name="text")
	val text: String? = null,

	@Json(name="type")
	val type: String? = null
) : Parcelable