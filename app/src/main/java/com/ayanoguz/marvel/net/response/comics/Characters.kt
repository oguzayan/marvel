package com.ayanoguz.marvel.net.response.comics

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Characters(

	@Json(name="collectionURI")
	val collectionURI: String? = null,

	@Json(name="available")
	val available: Int? = null,

	@Json(name="returned")
	val returned: Int? = null,

	@Json(name="items")
	val items: List<ItemsItem?>? = null
) : Parcelable