package com.ayanoguz.marvel.net.response.comics

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PricesItem(

    @Json(name = "price")
    val price: Double? = null,

    @Json(name = "type")
    val type: String? = null
) : Parcelable