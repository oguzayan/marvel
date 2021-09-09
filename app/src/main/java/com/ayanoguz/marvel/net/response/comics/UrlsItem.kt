package com.ayanoguz.marvel.net.response.comics

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UrlsItem(

	@Json(name="type")
	val type: String? = null,

	@Json(name="url")
	val url: String? = null
) : Parcelable