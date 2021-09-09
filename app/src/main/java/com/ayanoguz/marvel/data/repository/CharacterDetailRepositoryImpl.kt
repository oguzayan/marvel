package com.ayanoguz.marvel.data.repository

import com.ayanoguz.marvel.data.datasource.RemoteDataSource
import com.ayanoguz.marvel.net.response.comics.GetCharacterDetailResponse
import com.ayanoguz.marvel.util.Result
import javax.inject.Inject

class CharacterDetailRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : CharacterDetailRepository {

    override suspend fun getCharacterDetail(
        id: Int, limit: Int,
        dateRange: String,
        orderBy: String
    ): Result<GetCharacterDetailResponse> {
        return remoteDataSource.getCharacterDetail(id, limit, dateRange, orderBy)
    }
}