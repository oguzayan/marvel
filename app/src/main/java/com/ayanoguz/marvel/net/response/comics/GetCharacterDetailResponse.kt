package com.ayanoguz.marvel.net.response.comics

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GetCharacterDetailResponse(

	@Json(name="copyright")
	val copyright: String? = null,

	@Json(name="code")
	val code: Int? = null,

	@Json(name="data")
	val data: Data? = null,

	@Json(name="attributionHTML")
	val attributionHTML: String? = null,

	@Json(name="attributionText")
	val attributionText: String? = null,

	@Json(name="etag")
	val etag: String? = null,

	@Json(name="status")
	val status: String? = null
) : Parcelable