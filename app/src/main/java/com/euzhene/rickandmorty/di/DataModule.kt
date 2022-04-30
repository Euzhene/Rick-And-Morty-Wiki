package com.euzhene.rickandmorty.di

import com.euzhene.rickandmorty.data.network.CharacterService
import com.euzhene.rickandmorty.data.network.RetrofitInstance
import dagger.Module
import dagger.Provides

@Module
class DataModule {
    @Provides
    fun provideCharacterService(): CharacterService {
        return RetrofitInstance.api
    }
}