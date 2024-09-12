package com.onurkaraduman.musifyapp.presentation.search


import com.onurkaraduman.musifyapp.domain.model.search.SearchMusicsModel



data class SearchState(
    val searchQuery: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val words: List<SearchMusicsModel>? = null
)