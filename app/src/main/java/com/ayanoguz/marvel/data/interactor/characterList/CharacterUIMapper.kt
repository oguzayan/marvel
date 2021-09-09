package com.ayanoguz.marvel.data.interactor.characterList

import com.ayanoguz.marvel.net.response.GetCharacterListResponse
import javax.inject.Inject

class CharacterUIMapper @Inject constructor() {

    fun map(response: GetCharacterListResponse): List<CharacterUIModel> {
        return response.data?.results?.map { resultItem ->
            CharacterUIModel(
                id = resultItem?.id,
                name = resultItem?.name,
                image = "${resultItem?.thumbnail?.path}.${resultItem?.thumbnail?.extension}",
                description = resultItem?.description
            )
        } ?: emptyList()
    }
}