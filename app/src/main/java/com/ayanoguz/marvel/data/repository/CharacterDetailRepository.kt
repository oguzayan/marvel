package com.ayanoguz.marvel.data.repository


import com.ayanoguz.marvel.net.response.comics.GetCharacterDetailResponse
import com.ayanoguz.marvel.util.Result

interface CharacterDetailRepository {

    suspend fun getCharacterDetail(id:Int,limit: Int,
                                   dateRange: String,
                                   orderBy: String):Result<GetCharacterDetailResponse>

}