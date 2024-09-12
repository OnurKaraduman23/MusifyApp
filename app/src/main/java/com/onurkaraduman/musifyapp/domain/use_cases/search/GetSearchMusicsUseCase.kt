package com.onurkaraduman.musifyapp.domain.use_cases.search

import com.onurkaraduman.musifyapp.common.Resource
import com.onurkaraduman.musifyapp.data.mapper.search.mapSearchMusicResponseToDomain
import com.onurkaraduman.musifyapp.domain.model.search.SearchMusicsModel
import com.onurkaraduman.musifyapp.domain.repository.MusicRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetSearchMusicsUseCase @Inject constructor(
    private val musicRepository: MusicRepository
) {
    operator fun invoke(query: String): Flow<Resource<List<SearchMusicsModel>>> = flow {
        try {
            emit(Resource.Loading<List<SearchMusicsModel>>())
            val response = musicRepository.getSearchMusics(query)
            val searchResult = mapSearchMusicResponseToDomain(response)
            emit(Resource.Success<List<SearchMusicsModel>>(searchResult))
        } catch (e: IOException) {
            emit(
                Resource.Error<List<SearchMusicsModel>>(
                    "Couldn't reach server. Check your internet connection"
                )
            )
        } catch (e: Exception) {
            emit(
                Resource.Error<List<SearchMusicsModel>>(
                    e.localizedMessage ?: "An unexpected error occurred"
                )
            )

        }
    }
}