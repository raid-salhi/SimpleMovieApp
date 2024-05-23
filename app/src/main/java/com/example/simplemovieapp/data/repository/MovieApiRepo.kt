package com.example.simplemovieapp.data.repository

import com.example.simplemovieapp.data.network.MoviesApiInterface
import javax.inject.Inject

class MovieApiRepo @Inject constructor(private val apiInterface: MoviesApiInterface) {
    fun getMovies() = apiInterface.getMovies()
    fun getMovie(id: Int) = apiInterface.getMovieById(movieId = id)

}