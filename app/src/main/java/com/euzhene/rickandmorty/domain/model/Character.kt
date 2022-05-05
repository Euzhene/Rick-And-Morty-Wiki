package com.euzhene.rickandmorty.domain.model

data class Character(
    val episodeCount: Int,
    val gender: String,
    val id: Int,
    val image: String,
    val location: String,
    val name: String,
    val species: String,
    val status: String,
) {
    companion object {
        const val UNKNOWN_ID = -1
    }
}
