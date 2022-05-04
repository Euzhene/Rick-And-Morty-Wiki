package com.euzhene.rickandmorty.di

import com.euzhene.rickandmorty.presentation.CharacterListFragment
import dagger.Component

@ApplicationScope
@Component(modules = [DataModule::class, DomainModule::class])
interface AppComponent {
    fun inject(fragment:CharacterListFragment)

    @Component.Factory
    interface AppComponentFactory {
        fun create(): AppComponent
    }
}