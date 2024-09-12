package com.onurkaraduman.musifyapp.presentation.home

import MusicListState
import MusicState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onurkaraduman.musifyapp.common.handleMusicState
import com.onurkaraduman.musifyapp.domain.use_cases.discover.GetDiscoverMusicUseCase
import com.onurkaraduman.musifyapp.domain.use_cases.genre.GetGenresUseCase
import com.onurkaraduman.musifyapp.domain.use_cases.popular.GetPopularMusicsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getDiscoverMusicUseCase: GetDiscoverMusicUseCase,
    private val getGenresUseCase: GetGenresUseCase,
    private val getPopularMusicsUseCase: GetPopularMusicsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(MusicListState())
    val state: State<MusicListState> = _state

    init {
        loadDiscoverMusics()
        loadGenresMusics()
        loadPopularMusics()
    }

    private fun loadDiscoverMusics() {
        getDiscoverMusicUseCase().handleMusicState(
            viewModelScope,
            onStateChanged = { newState ->
                _state.value = _state.value.copy(discoverMusicState = MusicState.Discover(newState))
            }
        )
    }

    private fun loadGenresMusics() {
        getGenresUseCase().handleMusicState(
            viewModelScope,
            onStateChanged = { newState ->
                _state.value = _state.value.copy(genresState = MusicState.Genres(newState))
            }
        )
    }

    private fun loadPopularMusics() {
        getPopularMusicsUseCase().handleMusicState(
            viewModelScope,
            onStateChanged = { newState ->
                _state.value = _state.value.copy(popularMusicState = MusicState.Popular(newState))
            }
        )
    }
}
