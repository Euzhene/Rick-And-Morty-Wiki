package com.euzhene.rickandmorty.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Character(
    val episodeCount: Int,
    val gender: String,
    val id: Int,
    val image: String,
    val location: String,
    val name: String,
    val species: String,
    val status: String,
) : Parcelable
