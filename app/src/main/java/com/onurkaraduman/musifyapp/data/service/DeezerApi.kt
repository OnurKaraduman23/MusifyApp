package com.onurkaraduman.musifyapp.data.service

import com.onurkaraduman.musifyapp.data.remote.dto.discover.DiscoverMusicResponse
import com.onurkaraduman.musifyapp.data.remote.dto.genre.GenreResponse
import com.onurkaraduman.musifyapp.data.remote.dto.popular.PopularMusicsResponse
import com.onurkaraduman.musifyapp.data.remote.dto.search.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface DeezerApi {

    @GET("radio")
    suspend fun getDiscoverMusic():DiscoverMusicResponse

    @GET("genre")
    suspend fun getGenres(): GenreResponse

    @GET("radio/6/tracks")
    suspend fun getPopularMusics(): PopularMusicsResponse

    @GET("search")
    suspend fun getSearchMusics(
        @Query("q") query: String
    ): SearchResponse
}