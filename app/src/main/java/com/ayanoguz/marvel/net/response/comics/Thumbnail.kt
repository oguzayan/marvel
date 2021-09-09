package com.ayanoguz.marvel.net.response.comics

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Thumbnail(

	@Json(name="path")
	val path: String? = null,

	@Json(name="extension")
	val extension: String? = null
) : Parcelable