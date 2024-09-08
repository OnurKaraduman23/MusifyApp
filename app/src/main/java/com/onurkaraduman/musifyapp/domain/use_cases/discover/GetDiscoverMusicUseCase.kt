package com.onurkaraduman.musifyapp.domain.use_cases.discover

import com.onurkaraduman.musifyapp.common.Resource
import com.onurkaraduman.musifyapp.data.mapper.discover.mapDiscoverMusicResponseToDomain


import com.onurkaraduman.musifyapp.domain.model.discover.DiscoverMusicModel
import com.onurkaraduman.musifyapp.domain.repository.MusicRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetDiscoverMusicUseCase @Inject constructor(
    private val musicRepository: MusicRepository
) {
    operator fun invoke(): Flow<Resource<List<DiscoverMusicModel>>> = flow {
        try {
            emit(Resource.Loading<List<DiscoverMusicModel>>())
            val response = musicRepository.getMusicDiscover()
            val music = mapDiscoverMusicResponseToDomain(response)
            emit(Resource.Success<List<DiscoverMusicModel>>(music))
        } catch (e: IOException) {
            emit(Resource.Error<List<DiscoverMusicModel>>("Couldn't reach server. Check your internet connection"))
        } catch (e: Exception) {
            emit(Resource.Error<List<DiscoverMusicModel>>(e.localizedMessage ?: "An unexpected error occurred"))
        }
    }
}