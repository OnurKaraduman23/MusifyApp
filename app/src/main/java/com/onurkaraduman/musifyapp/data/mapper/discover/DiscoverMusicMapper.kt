package com.onurkaraduman.musifyapp.data.mapper.discover

import com.onurkaraduman.musifyapp.data.remote.dto.discover.DataDiscoverMusic
import com.onurkaraduman.musifyapp.data.remote.dto.discover.DiscoverMusicResponse
import com.onurkaraduman.musifyapp.domain.model.discover.DiscoverMusicModel

fun mapDiscoverMusicResponseToDomain(response: DiscoverMusicResponse): List<DiscoverMusicModel> {
    return response.dataDiscover.map { mapDataDiscoverMusicToDomain(it) }
}

private fun mapDataDiscoverMusicToDomain(data: DataDiscoverMusic): DiscoverMusicModel {
    return DiscoverMusicModel(
        id = data.id,
        pictureSmall = data.pictureSmall,
        title = data.title
    )
}