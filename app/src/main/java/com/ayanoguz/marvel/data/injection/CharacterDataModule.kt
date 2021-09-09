package com.ayanoguz.marvel.data.injection

import com.ayanoguz.marvel.data.repository.CharacterRepository
import com.ayanoguz.marvel.data.repository.CharacterRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class CharacterDataModule {

    @Binds
    abstract fun bindCharacterRepo(characterRepositoryImpl: CharacterRepositoryImpl): CharacterRepository
}