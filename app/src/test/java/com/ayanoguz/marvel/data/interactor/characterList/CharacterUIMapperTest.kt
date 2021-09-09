package com.ayanoguz.marvel.data.interactor.characterList

import com.ayanoguz.marvel.testUtil.MockData
import org.junit.Assert
import org.junit.Test

class CharacterUIMapperTest {

    val mapper = CharacterUIMapper()

    @Test
    fun test_Mapper() {
        val data = MockData.characterListResponse
        Assert.assertEquals(MockData.characterListUIModel, mapper.map(data))
    }
}