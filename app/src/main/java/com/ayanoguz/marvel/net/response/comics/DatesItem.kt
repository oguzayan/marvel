package com.ayanoguz.marvel.net.response.comics

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DatesItem(

	@Json(name="date")
	val date: String? = null,

	@Json(name="type")
	val type: String? = null
) : Parcelable