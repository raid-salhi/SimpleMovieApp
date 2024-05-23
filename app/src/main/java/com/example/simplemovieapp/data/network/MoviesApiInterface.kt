package com.example.simplemovieapp.data.network

import com.example.simplemovieapp.data.model.Movie
import com.example.simplemovieapp.data.model.Movies
import com.example.simplemovieapp.data.utils.Constant
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import javax.inject.Singleton

@Singleton
interface MoviesApiInterface {
    @GET("discover/movie")
    fun getMovies(
        @Header("Authorization") token: String = Constant.API_KEY
    ): Call<Movies>
    @GET("movie/{movie_id}")
    fun getMovieById(
        @Header("Authorization") token: String = Constant.API_KEY,
        @Path("movie_id") movieId: Int
    ): Call<Movie>
}