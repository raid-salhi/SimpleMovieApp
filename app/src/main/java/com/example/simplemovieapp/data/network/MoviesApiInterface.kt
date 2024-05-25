package com.example.simplemovieapp.data.network

import com.example.simplemovieapp.data.model.Movie
import com.example.simplemovieapp.data.model.Movies
import com.example.simplemovieapp.data.utils.Constant
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface MoviesApiInterface {
    @GET(Constant.ALL_MOVIES_PATH)
    fun getMovies(
        @Query("api_key") token: String = Constant.API_KEY
    ): Call<Movies>
    @GET(Constant.MOVIE_PATH)
    fun getMovieById(
        @Path("movie_id") movieId: Int,
        @Query("api_key") token: String = Constant.API_KEY,
    ): Call<Movie>
}