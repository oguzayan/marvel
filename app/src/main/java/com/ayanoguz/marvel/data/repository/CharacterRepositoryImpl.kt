package com.ayanoguz.marvel.data.repository

import com.ayanoguz.marvel.data.datasource.RemoteDataSource
import com.ayanoguz.marvel.net.response.GetCharacterListResponse
import com.ayanoguz.marvel.util.Result
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
):CharacterRepository {
    override suspend fun getCharacterList(limit:Int,offset:Int): Result<GetCharacterListResponse> {
        return remoteDataSource.getCharacterList(limit = limit,offset = offset)
    }

}