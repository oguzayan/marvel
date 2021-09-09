package com.ayanoguz.marvel.data.injection

import com.ayanoguz.marvel.data.repository.CharacterDetailRepository
import com.ayanoguz.marvel.data.repository.CharacterDetailRepositoryImpl
import com.ayanoguz.marvel.data.repository.CharacterRepository
import com.ayanoguz.marvel.data.repository.CharacterRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class CharacterDetailDataModule {

    @Binds
    abstract fun bindCharacterDetailRepo(characterDetailRepositoryImpl: CharacterDetailRepositoryImpl): CharacterDetailRepository
}