package com.ayanoguz.marvel.net.response

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GetCharacterListResponse(

    @Json(name = "copyright")
    val copyright: String? = null,

    @Json(name = "code")
    val code: Int? = null,

    @Json(name = "data")
    val data: Data? = null,

    @Json(name = "attributionHTML")
    val attributionHTML: String? = null,

    @Json(name = "attributionText")
    val attributionText: String? = null,

    @Json(name = "etag")
    val etag: String? = null,

    @Json(name = "status")
    val status: String? = null
) : Parcelable

@Parcelize
data class ItemsItem(

    @Json(name = "name")
    val name: String? = null,

    @Json(name = "resourceURI")
    val resourceURI: String? = null
) : Parcelable

@Parcelize
data class Thumbnail(

    @Json(name = "path")
    val path: String? = null,

    @Json(name = "extension")
    val extension: String? = null
) : Parcelable

@Parcelize
data class Series(

    @Json(name = "collectionURI")
    val collectionURI: String? = null,

    @Json(name = "available")
    val available: Int? = null,

    @Json(name = "returned")
    val returned: Int? = null,

    @Json(name = "items")
    val items: List<ItemsItem?>? = null
) : Parcelable

@Parcelize
data class Comics(

    @Json(name = "collectionURI")
    val collectionURI: String? = null,

    @Json(name = "available")
    val available: Int? = null,

    @Json(name = "returned")
    val returned: Int? = null,

    @Json(name = "items")
    val items: List<ItemsItem?>? = null
) : Parcelable

@Parcelize
data class UrlsItem(

    @Json(name = "type")
    val type: String? = null,

    @Json(name = "url")
    val url: String? = null
) : Parcelable

@Parcelize
data class Stories(

    @Json(name = "collectionURI")
    val collectionURI: String? = null,

    @Json(name = "available")
    val available: Int? = null,

    @Json(name = "returned")
    val returned: Int? = null,

    @Json(name = "items")
    val items: List<ItemsItem?>? = null
) : Parcelable

@Parcelize
data class Events(

    @Json(name = "collectionURI")
    val collectionURI: String? = null,

    @Json(name = "available")
    val available: Int? = null,

    @Json(name = "returned")
    val returned: Int? = null,

    @Json(name = "items")
    val items: List<ItemsItem?>? = null
) : Parcelable

@Parcelize
data class ResultsItem(

    @Json(name = "thumbnail")
    val thumbnail: Thumbnail? = null,

    @Json(name = "urls")
    val urls: List<UrlsItem?>? = null,

    @Json(name = "stories")
    val stories: Stories? = null,

    @Json(name = "series")
    val series: Series? = null,

    @Json(name = "comics")
    val comics: Comics? = null,

    @Json(name = "name")
    val name: String? = null,

    @Json(name = "description")
    val description: String? = null,

    @Json(name = "modified")
    val modified: String? = null,

    @Json(name = "id")
    val id: Int? = null,

    @Json(name = "resourceURI")
    val resourceURI: String? = null,

    @Json(name = "events")
    val events: Events? = null
) : Parcelable

@Parcelize
data class Data(

    @Json(name = "total")
    val total: Int? = null,

    @Json(name = "offset")
    val offset: Int? = null,

    @Json(name = "limit")
    val limit: Int? = null,

    @Json(name = "count")
    val count: Int? = null,

    @Json(name = "results")
    val results: List<ResultsItem?>? = null
) : Parcelable
