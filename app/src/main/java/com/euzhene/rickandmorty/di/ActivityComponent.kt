package com.euzhene.rickandmorty.di

import com.euzhene.rickandmorty.presentation.CharacterInfoFragment
import com.euzhene.rickandmorty.presentation.CharacterListFragment
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(
)
interface ActivityComponent {

    fun inject(fragment: CharacterInfoFragment)
    fun inject(fragment: CharacterListFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance id: Int): ActivityComponent
    }
}