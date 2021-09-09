package com.ayanoguz.marvel.data.datasource

import com.ayanoguz.marvel.net.MarvelAPI
import com.ayanoguz.marvel.net.response.GetCharacterListResponse
import com.ayanoguz.marvel.net.response.comics.GetCharacterDetailResponse
import  com.ayanoguz.marvel.util.Result
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val service: MarvelAPI
) {

    suspend fun getCharacterList(limit: Int, offset: Int): Result<GetCharacterListResponse> {
        return try {
            Result.Success(service.getCharacterList(limit = limit, offset = offset))
        } catch (ex: Exception) {
            Result.Failure(ex)
        }
    }

    suspend fun getCharacterDetail(
        id: Int,
        limit: Int,
        dateRange: String,
        orderBy: String
    ): Result<GetCharacterDetailResponse> {
        return try {
            Result.Success(
                service.getCharacterDetail(
                    id,
                    limit = limit,
                    dateRange = dateRange,
                    orderBy = orderBy
                )
            )
        } catch (ex: Exception) {
            Result.Failure(ex)
        }
    }
}