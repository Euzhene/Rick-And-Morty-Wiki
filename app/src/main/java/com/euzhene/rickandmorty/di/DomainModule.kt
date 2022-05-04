package com.euzhene.rickandmorty.di

import com.euzhene.rickandmorty.data.repository.CharacterRepositoryImpl
import com.euzhene.rickandmorty.domain.repository.CharacterRepository
import dagger.Binds
import dagger.Module

@Module
interface DomainModule {
    @Binds
    fun bindCharacterRepository(impl:CharacterRepositoryImpl):CharacterRepository
}