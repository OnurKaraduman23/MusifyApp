package com.onurkaraduman.musifyapp.common

import GenericMusicState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

fun <T> Flow<Resource<List<T>>>.handleMusicState(
    coroutineScope: CoroutineScope,
    onStateChanged: (GenericMusicState<T>) -> Unit
) {
    onEach { result ->
        val newState = when (result) { //Her state için yazmaktansa bu daha iyi
            is Resource.Success -> GenericMusicState(isLoading = false, data = result.data ?: emptyList())
            is Resource.Loading -> GenericMusicState(isLoading = true)
            is Resource.Error -> GenericMusicState(isLoading = false, error = result.message.toString())
        }
        onStateChanged(newState)
    }.launchIn(coroutineScope)
}