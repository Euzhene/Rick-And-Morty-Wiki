package com.euzhene.rickandmorty.di

import com.euzhene.rickandmorty.data.dataSource.CharacterRemoteDataSource
import com.euzhene.rickandmorty.data.dataSourceImpl.CharacterRemoteDataSourceImpl
import com.euzhene.rickandmorty.data.network.CharacterService
import com.euzhene.rickandmorty.data.network.RetrofitInstance
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class DataModule {
    companion object {
        @Provides
        fun provideCharacterService(): CharacterService {
            return RetrofitInstance().api
        }
    }

    @Binds
    abstract fun bindCharacterRemoteDataSource(impl: CharacterRemoteDataSourceImpl)
            : CharacterRemoteDataSource
}