package com.euzhene.rickandmorty.data.network.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GetResponseDto(
    val info: InfoDto,
    val results: List<CharacterDto>
)

@JsonClass(generateAdapter = true)
data class InfoDto(
    val count: Int,
    val next: String?,
    val pages: Int,
    val prev: String?
)


@JsonClass(generateAdapter = true)
data class CharacterDto(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: LocationDto?,
    val name: String,
    val origin: OriginDto?,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

@JsonClass(generateAdapter = true)
data class LocationDto(
    val name: String,
    val url: String
)

@JsonClass(generateAdapter = true)
data class OriginDto(
    val name: String,
    val url: String
)