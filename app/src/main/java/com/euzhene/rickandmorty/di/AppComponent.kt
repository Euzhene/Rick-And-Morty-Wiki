package com.euzhene.rickandmorty.di

import com.euzhene.rickandmorty.presentation.CharacterListFragment
import dagger.Component

@ApplicationScope
@Component(modules = [DataModule::class, DomainModule::class, ViewModelModule::class])
interface AppComponent {

    fun fragmentComponentFactory():ActivityComponent.Factory

    @Component.Factory
    interface AppComponentFactory {
        fun create(): AppComponent
    }
}