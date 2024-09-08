package com.onurkaraduman.musifyapp.data.service

import com.onurkaraduman.musifyapp.data.remote.dto.discover.DiscoverMusicResponse
import com.onurkaraduman.musifyapp.data.remote.dto.genre.GenreResponse
import retrofit2.http.GET

interface DeezerApi {

    @GET("radio")
    suspend fun getDiscoverMusic():DiscoverMusicResponse

    @GET("genre")
    suspend fun getGenres(): GenreResponse
}