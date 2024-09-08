package com.onurkaraduman.musifyapp.data.mapper.genre

import com.onurkaraduman.musifyapp.data.remote.dto.genre.DataGenre
import com.onurkaraduman.musifyapp.data.remote.dto.genre.GenreResponse
import com.onurkaraduman.musifyapp.domain.model.genre.GenresModel

fun mapGenresResponseToDomain(response: GenreResponse): List<GenresModel> {
    return response.dataGenre.map { mapDataGenreToDomain(it) }
}

fun mapDataGenreToDomain(data: DataGenre): GenresModel {
    return GenresModel(
        id = data.id,
        pictureSmall = data.pictureSmall,
        name = data.name
    )
}