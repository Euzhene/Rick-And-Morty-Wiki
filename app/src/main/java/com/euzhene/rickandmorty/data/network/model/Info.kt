package com.euzhene.rickandmorty.data.network.model

data class Info(
    val count: Int,
    val next: String?,
    val pages: Int,
    val prev: String?
)