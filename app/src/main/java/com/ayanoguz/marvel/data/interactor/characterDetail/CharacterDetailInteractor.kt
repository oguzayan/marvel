package com.ayanoguz.marvel.data.interactor.characterDetail


import com.ayanoguz.marvel.data.repository.CharacterDetailRepository
import com.ayanoguz.marvel.util.Result
import com.ayanoguz.marvel.util.UIState
import javax.inject.Inject

class CharacterDetailInteractor @Inject constructor(
    private val characterDetailRepository: CharacterDetailRepository,
    private val characterDetailUIMapper: CharacterDetailUIMapper
) {
    suspend fun getCharacterDetail(
        id: Int, limit: Int,
        dateRange: String,
        orderBy: String
    ): UIState<List<ComicsUIModel>> {
        return when (val detail =
            characterDetailRepository.getCharacterDetail(id, limit, dateRange, orderBy)) {
            is Result.Success -> UIState.Data(characterDetailUIMapper.map(detail.data))
            is Result.Failure -> UIState.Error(detail.error)
        }
    }

}