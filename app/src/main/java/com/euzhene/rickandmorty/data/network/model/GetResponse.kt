package com.euzhene.rickandmorty.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GetResponse(
    val info: InfoResponse,
    val results: List<CharacterResponse>
)

@JsonClass(generateAdapter = true)
data class InfoResponse(
    val count: Int,
    val next: String?,
    val pages: Int,
    val prev: String?
)


@JsonClass(generateAdapter = true)
data class CharacterResponse(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: LocationResponse?,
    val name: String,
    val origin: OriginResponse?,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

@JsonClass(generateAdapter = true)
data class LocationResponse(
    val name: String,
    val url: String
)

@JsonClass(generateAdapter = true)
data class OriginResponse(
    val name: String,
    val url: String
)