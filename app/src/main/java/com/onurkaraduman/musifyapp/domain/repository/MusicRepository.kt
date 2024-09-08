package com.onurkaraduman.musifyapp.domain.repository

import com.onurkaraduman.musifyapp.data.remote.dto.discover.DiscoverMusicResponse
import com.onurkaraduman.musifyapp.data.remote.dto.genre.GenreResponse

interface MusicRepository {

    suspend fun getMusicDiscover(): DiscoverMusicResponse
    suspend fun getGenres(): GenreResponse
}