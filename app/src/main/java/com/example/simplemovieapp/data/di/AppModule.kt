package com.example.simplemovieapp.data.di

import com.example.simplemovieapp.data.network.MoviesApiInterface
import com.example.simplemovieapp.data.utils.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class AppModule(){
    @Singleton
    @Provides
    fun provideMoviesApi(): MoviesApiInterface = Retrofit.Builder()
        .baseUrl(Constant.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MoviesApiInterface::class.java)

}