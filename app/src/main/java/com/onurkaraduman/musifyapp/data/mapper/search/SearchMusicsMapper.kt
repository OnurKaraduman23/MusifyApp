package com.onurkaraduman.musifyapp.data.mapper.search

import com.onurkaraduman.musifyapp.data.remote.dto.search.SearchResponse
import com.onurkaraduman.musifyapp.domain.model.search.SearchMusicsModel

fun mapSearchMusicResponseToDomain(response: SearchResponse): List<SearchMusicsModel> {
    return response.searchData.map { data ->
        SearchMusicsModel(
            id = data.id,
            title = data.title,
            pictureSmall = data.album.coverSmall,
            artistName = data.artist.name,
            total = response.total,
            next = response.next
        )
    }
}