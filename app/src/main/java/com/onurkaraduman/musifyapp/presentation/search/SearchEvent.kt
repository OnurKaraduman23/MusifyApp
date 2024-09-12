package com.onurkaraduman.musifyapp.presentation.search

sealed class SearchEvent {

    data class UpdateSearchQuery(val searchQuery: String): SearchEvent()

    data object SearchMusics : SearchEvent()
}