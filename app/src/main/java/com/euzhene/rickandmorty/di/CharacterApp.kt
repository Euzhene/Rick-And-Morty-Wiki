package com.euzhene.rickandmorty.di

import android.app.Application

class CharacterApp:Application() {
    val component:AppComponent by lazy {
        DaggerAppComponent.create()
    }
}