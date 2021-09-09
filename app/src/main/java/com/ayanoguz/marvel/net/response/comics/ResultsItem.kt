package com.ayanoguz.marvel.net.response.comics

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResultsItem(

	@Json(name="creators")
	val creators: Creators? = null,

	@Json(name="issueNumber")
	val issueNumber: Int? = null,

	@Json(name="isbn")
	val isbn: String? = null,

	@Json(name="description")
	val description: String? = null,


	@Json(name="title")
	val title: String? = null,

	@Json(name="diamondCode")
	val diamondCode: String? = null,

	@Json(name="characters")
	val characters: Characters? = null,

	@Json(name="urls")
	val urls: List<UrlsItem?>? = null,

	@Json(name="ean")
	val ean: String? = null,


	@Json(name="modified")
	val modified: String? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="prices")
	val prices: List<PricesItem?>? = null,

	@Json(name="events")
	val events: Events? = null,


	@Json(name="pageCount")
	val pageCount: Int? = null,

	@Json(name="thumbnail")
	val thumbnail: Thumbnail? = null,

	@Json(name="images")
	val images: List<ImagesItem?>? = null,

	@Json(name="stories")
	val stories: Stories? = null,

	@Json(name="textObjects")
	val textObjects: List<TextObjectsItem?>? = null,

	@Json(name="digitalId")
	val digitalId: Int? = null,

	@Json(name="format")
	val format: String? = null,

	@Json(name="upc")
	val upc: String? = null,

	@Json(name="dates")
	val dates: List<DatesItem?>? = null,

	@Json(name="resourceURI")
	val resourceURI: String? = null,

	@Json(name="variantDescription")
	val variantDescription: String? = null,

	@Json(name="issn")
	val issn: String? = null,

	@Json(name="series")
	val series: Series? = null
) : Parcelable