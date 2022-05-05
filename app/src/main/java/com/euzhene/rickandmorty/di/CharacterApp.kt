package com.euzhene.rickandmorty.di

import android.app.Application
import dagger.internal.DaggerCollections

class CharacterApp : Application() {
    val component: AppComponent by lazy {
        DaggerAppComponent.create()
    }
}