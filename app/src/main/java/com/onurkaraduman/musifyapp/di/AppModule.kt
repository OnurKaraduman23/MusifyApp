package com.onurkaraduman.musifyapp.di

import com.onurkaraduman.musifyapp.common.Constants.BASE_URL
import com.onurkaraduman.musifyapp.data.repository.MusicRepositoryImpl
import com.onurkaraduman.musifyapp.data.service.DeezerApi
import com.onurkaraduman.musifyapp.domain.repository.MusicRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideWordRetrofit(): DeezerApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DeezerApi::class.java)
    }


    @Provides
    @Singleton
    fun provideMusicRepository(deezerApi: DeezerApi): MusicRepository {
        return MusicRepositoryImpl(deezerApi)
    }
}