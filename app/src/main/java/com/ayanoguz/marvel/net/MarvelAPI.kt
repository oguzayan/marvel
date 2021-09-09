package com.ayanoguz.marvel.net

import com.ayanoguz.marvel.net.response.GetCharacterListResponse
import com.ayanoguz.marvel.net.response.comics.GetCharacterDetailResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelAPI {

    @GET("characters")
    suspend fun getCharacterList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): GetCharacterListResponse

    @GET("characters/{id}/comics")
    suspend fun getCharacterDetail(
        @Path("id") id: Int,
        @Query("limit") limit:Int,
        @Query("dateRange") dateRange:String,
        @Query("orderBy") orderBy:String
    ): GetCharacterDetailResponse

}