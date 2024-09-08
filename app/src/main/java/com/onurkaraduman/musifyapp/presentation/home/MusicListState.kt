package com.onurkaraduman.musifyapp.presentation.home


import com.onurkaraduman.musifyapp.domain.model.discover.DiscoverMusicModel
import com.onurkaraduman.musifyapp.domain.model.genre.GenresModel


data class MusicListState(
    val discoverMusicsState: DiscoverMusicsState = DiscoverMusicsState(),
    val genresMusicsState: GenresMusicsState = GenresMusicsState(),
)

data class DiscoverMusicsState(
    val isLoading: Boolean = false,
    val musics: List<DiscoverMusicModel> = emptyList(),
    val error: String = ""
)

data class GenresMusicsState(
    val isLoading: Boolean = false,
    val musics: List<GenresModel> = emptyList(),
    val error: String = ""
)