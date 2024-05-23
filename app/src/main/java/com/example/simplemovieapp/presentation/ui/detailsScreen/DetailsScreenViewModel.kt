package com.example.simplemovieapp.presentation.ui.detailsScreen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simplemovieapp.data.model.Movie
import com.example.simplemovieapp.data.model.Movies
import com.example.simplemovieapp.data.repository.MovieApiRepo
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class DetailsScreenViewModel @Inject constructor(private val repo: MovieApiRepo): ViewModel(){
    private val _movie = mutableStateOf<Movie?>(null)
    val movie = _movie.value

    fun getMovie(id: Int){
        viewModelScope.launch {
           repo.getMovie(id).enqueue(object : Callback<Movie> {
               override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                   if (response.isSuccessful) {
                       _movie.value = response.body()
                   } else {
                       Log.d("MovieApi", "onResponse: failed fetch data")
                   }
               }
               override fun onFailure(call: Call<Movie>, t: Throwable) {
                   Log.d("MovieApi", "onFailure: failed fetch data, check your internet connection ${t.message}")
               }
           })
        }
    }
}