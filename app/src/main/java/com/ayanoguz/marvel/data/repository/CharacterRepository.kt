package com.ayanoguz.marvel.data.repository

import com.ayanoguz.marvel.net.response.GetCharacterListResponse
import com.ayanoguz.marvel.util.Result

interface CharacterRepository {

    suspend fun getCharacterList(limit:Int,offset:Int):Result<GetCharacterListResponse>

}