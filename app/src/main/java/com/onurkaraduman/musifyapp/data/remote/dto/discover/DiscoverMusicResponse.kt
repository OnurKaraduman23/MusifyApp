package com.onurkaraduman.musifyapp.data.remote.dto.discover


import com.google.gson.annotations.SerializedName

data class DiscoverMusicResponse(
    @SerializedName("data")
    val dataDiscover: List<DataDiscoverMusic>
)