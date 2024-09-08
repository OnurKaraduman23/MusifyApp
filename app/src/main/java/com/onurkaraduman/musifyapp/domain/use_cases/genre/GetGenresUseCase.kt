package com.onurkaraduman.musifyapp.domain.use_cases.genre

import com.onurkaraduman.musifyapp.common.Resource
import com.onurkaraduman.musifyapp.data.mapper.genre.mapGenresResponseToDomain
import com.onurkaraduman.musifyapp.domain.model.genre.GenresModel
import com.onurkaraduman.musifyapp.domain.repository.MusicRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import javax.inject.Inject

class GetGenresUseCase @Inject constructor(
    private val musicRepository: MusicRepository
){
    operator fun invoke(): Flow<Resource<List<GenresModel>>> = flow {
        try {
            emit(Resource.Loading<List<GenresModel>>())
            val response = musicRepository.getGenres()
            val music = mapGenresResponseToDomain(response)
            emit(Resource.Success<List<GenresModel>>(music))
        }catch (e: IOException) {
            emit(Resource.Error<List<GenresModel>>("Couldn't reach server. Check your internet connection"))

        } catch (e: Exception) {
            emit(Resource.Error<List<GenresModel>>(e.localizedMessage ?: "An unexpected error occurred"))
        }
    }
}