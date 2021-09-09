package com.ayanoguz.marvel.net.response.comics

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Data(

	@Json(name="total")
	val total: Int? = null,

	@Json(name="offset")
	val offset: Int? = null,

	@Json(name="limit")
	val limit: Int? = null,

	@Json(name="count")
	val count: Int? = null,

	@Json(name="results")
	val results: List<ResultsItem?>? = null
) : Parcelable