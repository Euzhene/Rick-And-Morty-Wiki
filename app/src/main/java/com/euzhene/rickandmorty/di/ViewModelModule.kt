package com.euzhene.rickandmorty.di

import androidx.lifecycle.ViewModel
import com.euzhene.rickandmorty.presentation.CharacterInfoViewModel
import com.euzhene.rickandmorty.presentation.CharacterListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(subcomponents = [ActivityComponent::class])
interface ViewModelModule {
    @IntoMap
    @ViewModelKey(CharacterListViewModel::class)
    @Binds
    fun bindCharacterListViewModel(viewModel: CharacterListViewModel): ViewModel

    @IntoMap
    @ViewModelKey(CharacterInfoViewModel::class)
    @Binds
    fun bindCharacterInfoViewModel(viewModel: CharacterInfoViewModel): ViewModel

}