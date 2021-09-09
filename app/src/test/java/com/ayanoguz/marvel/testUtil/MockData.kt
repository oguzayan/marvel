package com.ayanoguz.marvel.testUtil

import com.ayanoguz.marvel.data.interactor.characterDetail.ComicsUIModel
import com.ayanoguz.marvel.data.interactor.characterList.CharacterUIModel
import com.ayanoguz.marvel.net.response.Data
import com.ayanoguz.marvel.net.response.GetCharacterListResponse
import com.ayanoguz.marvel.net.response.ResultsItem
import com.ayanoguz.marvel.net.response.Thumbnail
import com.ayanoguz.marvel.net.response.comics.DatesItem
import com.ayanoguz.marvel.net.response.comics.GetCharacterDetailResponse

object MockData {
    val characterListResponse = GetCharacterListResponse(
        data = Data(
            results = listOf(
                getCharacter(1),
                getCharacter(2),
                getCharacter(3),
                getCharacter(4),
                getCharacter(5)
            )
        )
    )

    val characterListUIModel = listOf(
        getCharacterUIModel(1),
        getCharacterUIModel(2),
        getCharacterUIModel(3),
        getCharacterUIModel(4),
        getCharacterUIModel(5)
    )

    val characterDetailResponse = GetCharacterDetailResponse(
        data = com.ayanoguz.marvel.net.response.comics.Data(
            results = listOf(
                getComics(1),
                getComics(2),
                getComics(3),
                getComics(4),
                getComics(5)
            )
        )
    )

    val characterDetailUIModel = listOf(
        getComisUIModel(1),
        getComisUIModel(2),
        getComisUIModel(3),
        getComisUIModel(4),
        getComisUIModel(5)
    )

    fun getCharacter(id: Int): ResultsItem {
        return ResultsItem(
            thumbnail = Thumbnail("image_$id", "png"),
            name = "Character $id",
            description = "Character $id description",
            id = id
        )
    }

    fun getCharacterUIModel(id: Int): CharacterUIModel {
        return CharacterUIModel(
            image = "image_$id.png",
            name = "Character $id",
            description = "Character $id description",
            id = id
        )
    }

    private fun getComics(id: Int): com.ayanoguz.marvel.net.response.comics.ResultsItem {
        return com.ayanoguz.marvel.net.response.comics.ResultsItem(
            id = id,
            title = "Comic $id",
            thumbnail = com.ayanoguz.marvel.net.response.comics.Thumbnail("image_$id", "png"),
            dates = listOf(DatesItem("${2021.minus(id)}.01.01", type = "onsaleDate")),
            description = "Comic $id description"
        )
    }

    private fun getComisUIModel(id: Int): ComicsUIModel {
        return ComicsUIModel(
            id = id,
            name = "Comic $id",
            image = "image_$id.png",
            year = "${2021.minus(id)}",
            description = "Comic $id description"
        )
    }
}