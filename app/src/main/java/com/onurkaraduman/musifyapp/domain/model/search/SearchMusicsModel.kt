package com.onurkaraduman.musifyapp.domain.model.search

data class SearchMusicsModel(
    val id: Long,
    val artistName: String,
    val title: String,
    val pictureSmall: String,
    val next: String,
    val total: Int
)
