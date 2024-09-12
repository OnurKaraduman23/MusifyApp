package com.onurkaraduman.musifyapp.data.repository

import com.onurkaraduman.musifyapp.data.remote.dto.discover.DiscoverMusicResponse
import com.onurkaraduman.musifyapp.data.remote.dto.genre.GenreResponse
import com.onurkaraduman.musifyapp.data.remote.dto.popular.PopularMusicsResponse
import com.onurkaraduman.musifyapp.data.remote.dto.search.SearchResponse
import com.onurkaraduman.musifyapp.data.service.DeezerApi
import com.onurkaraduman.musifyapp.domain.repository.MusicRepository
import javax.inject.Inject

class MusicRepositoryImpl @Inject constructor(
    private val deezerApi: DeezerApi
) : MusicRepository {
    override suspend fun getMusicDiscover(): DiscoverMusicResponse {
        return deezerApi.getDiscoverMusic()
    }

    override suspend fun getGenres(): GenreResponse {
        return deezerApi.getGenres()
    }

    override suspend fun getPopularMusics(): PopularMusicsResponse {
        return deezerApi.getPopularMusics()
    }

    override suspend fun getSearchMusics(query: String): SearchResponse {
        return deezerApi.getSearchMusics(query)
    }
}