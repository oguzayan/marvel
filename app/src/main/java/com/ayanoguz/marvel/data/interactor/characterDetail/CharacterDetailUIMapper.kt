package com.ayanoguz.marvel.data.interactor.characterDetail

import com.ayanoguz.marvel.net.response.comics.GetCharacterDetailResponse
import javax.inject.Inject

class CharacterDetailUIMapper @Inject constructor() {

    fun map(response: GetCharacterDetailResponse): List<ComicsUIModel> {
        return response.data?.results?.map { resultItem ->
            ComicsUIModel(
                id = resultItem?.id,
                name = resultItem?.title,
                image = "${resultItem?.thumbnail?.path}.${resultItem?.thumbnail?.extension}",
                year = resultItem?.dates?.find { it?.type == "onsaleDate" }?.date?.substring(0, 4)
                    ?: "",
                description = resultItem?.description
            )
        } ?: emptyList()
    }
}