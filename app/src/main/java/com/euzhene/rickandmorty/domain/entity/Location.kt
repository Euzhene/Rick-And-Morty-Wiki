package com.euzhene.rickandmorty.domain.entity

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Location(
    val name: String,
    val url: String
) : Parcelable