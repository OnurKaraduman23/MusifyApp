package com.onurkaraduman.musifyapp.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onurkaraduman.musifyapp.common.Resource
import com.onurkaraduman.musifyapp.domain.use_cases.discover.GetDiscoverMusicUseCase
import com.onurkaraduman.musifyapp.domain.use_cases.genre.GetGenresUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getDiscoverMusicUseCase: GetDiscoverMusicUseCase,
    private val getGenresUseCase: GetGenresUseCase
) : ViewModel() {

    private val _state = mutableStateOf<MusicListState>(MusicListState())
    val state: State<MusicListState> = _state

    init {
        loadDiscoverMusics()
        loadGenresMusics()
    }


    private fun loadDiscoverMusics() {
        getDiscoverMusicUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = _state.value.copy(
                        discoverMusicsState = DiscoverMusicsState(
                            isLoading = false,
                            musics = result.data ?: emptyList()
                        )
                    )
                }

                is Resource.Loading -> {
                    _state.value = _state.value.copy(
                        discoverMusicsState = DiscoverMusicsState(
                            isLoading = true
                        )
                    )
                }

                is Resource.Error -> {
                    _state.value = _state.value.copy(
                        discoverMusicsState = DiscoverMusicsState(
                            error = result.message.toString()
                        )
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun loadGenresMusics(){
        getGenresUseCase().onEach {result->
            when(result) {
                is Resource.Success -> {
                    _state.value = _state.value.copy(
                        genresMusicsState = GenresMusicsState(
                            isLoading = false,
                            musics = result.data ?: emptyList()
                        )
                    )
                }
                is Resource.Loading -> {
                    _state.value = _state.value.copy(
                      genresMusicsState =  GenresMusicsState(
                          isLoading = true
                      )
                    )
                }
                is Resource.Error -> {
                    _state.value = _state.value.copy(
                        genresMusicsState = GenresMusicsState(
                            error = result.message.toString()
                        )
                    )
                }
            }

        }.launchIn(viewModelScope)
    }
}