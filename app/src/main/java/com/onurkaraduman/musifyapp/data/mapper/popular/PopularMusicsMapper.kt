package com.onurkaraduman.musifyapp.data.mapper.popular

import com.onurkaraduman.musifyapp.data.remote.dto.popular.PopularMusicsResponse
import com.onurkaraduman.musifyapp.domain.model.popular.PopularMusicsModel

fun mapPopularMusicsResponseToDomain(response: PopularMusicsResponse): List<PopularMusicsModel> {
    return response.popularMusicsData.map { data ->
        PopularMusicsModel(
            picture = data.artist.pictureSmall, // veya data.album.coverSmall
            title = data.title,
            previewMusic = data.preview,
            artistName = data.artist.name,
            pictureSmall = data.album.coverSmall // veya data.artist.pictureSmall
        )
    }
}