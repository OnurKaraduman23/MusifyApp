package com.onurkaraduman.musifyapp.data.remote.dto.genre


import com.google.gson.annotations.SerializedName

data class GenreResponse(
    @SerializedName("data")
    val dataGenre: List<DataGenre>
)