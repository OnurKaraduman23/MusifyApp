package com.onurkaraduman.musifyapp.domain.use_cases.popular

import com.onurkaraduman.musifyapp.common.Resource
import com.onurkaraduman.musifyapp.data.mapper.popular.mapPopularMusicsResponseToDomain
import com.onurkaraduman.musifyapp.domain.model.popular.PopularMusicsModel
import com.onurkaraduman.musifyapp.domain.repository.MusicRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetPopularMusicsUseCase @Inject constructor(
    private val musicRepository: MusicRepository
) {
    operator fun invoke(): Flow<Resource<List<PopularMusicsModel>>> = flow {
        try {
            emit(Resource.Loading<List<PopularMusicsModel>>())
            val response = musicRepository.getPopularMusics()
            val music = mapPopularMusicsResponseToDomain(response)
            emit(Resource.Success<List<PopularMusicsModel>>(music))
        } catch (e: IOException) {
            emit(Resource.Error<List<PopularMusicsModel>>("Couldn't reach server. Check your internet connection"))

        } catch (e: Exception) {
            emit(
                Resource.Error<List<PopularMusicsModel>>(
                    e.localizedMessage ?: "An unexpected error occurred"
                )
            )
        }
    }
}