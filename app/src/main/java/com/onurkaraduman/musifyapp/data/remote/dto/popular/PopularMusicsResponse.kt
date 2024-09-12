package com.onurkaraduman.musifyapp.data.remote.dto.popular


import com.google.gson.annotations.SerializedName

data class PopularMusicsResponse(
    @SerializedName("data")
    val popularMusicsData: List<PopularMusicsData>
)