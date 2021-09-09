package com.ayanoguz.marvel.net.response.comics

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemsItem(

	@Json(name="name")
	val name: String? = null,

	@Json(name="resourceURI")
	val resourceURI: String? = null,

	@Json(name="type")
	val type: String? = null
) : Parcelable