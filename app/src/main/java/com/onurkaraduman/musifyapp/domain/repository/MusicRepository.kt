package com.onurkaraduman.musifyapp.domain.repository

import com.onurkaraduman.musifyapp.data.remote.dto.discover.DiscoverMusicResponse
import com.onurkaraduman.musifyapp.data.remote.dto.genre.GenreResponse
import com.onurkaraduman.musifyapp.data.remote.dto.popular.PopularMusicsResponse
import com.onurkaraduman.musifyapp.data.remote.dto.search.SearchResponse

interface MusicRepository {

    suspend fun getMusicDiscover(): DiscoverMusicResponse
    suspend fun getGenres(): GenreResponse
    suspend fun getPopularMusics(): PopularMusicsResponse
    suspend fun getSearchMusics(query: String): SearchResponse
}