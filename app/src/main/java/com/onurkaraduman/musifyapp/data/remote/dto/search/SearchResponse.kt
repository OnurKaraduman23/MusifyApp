package com.onurkaraduman.musifyapp.data.remote.dto.search


import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("data")
    val searchData: List<DataSearch>,
    @SerializedName("next")
    val next: String,
    @SerializedName("total")
    val total: Int
)