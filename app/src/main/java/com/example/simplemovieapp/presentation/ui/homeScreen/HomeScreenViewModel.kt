package com.example.simplemovieapp.presentation.ui.homeScreen

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simplemovieapp.data.model.Movie
import com.example.simplemovieapp.data.model.Movies
import com.example.simplemovieapp.data.repository.MovieApiRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val repo: MovieApiRepo): ViewModel() {
    private val _list = mutableStateOf(Movies(0,emptyList()))
    val movieList= _list
    init {
        getMovies()
    }
    private fun getMovies(){
        viewModelScope.launch {
            repo.getMovies().enqueue(object : Callback<Movies> {
                override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                    if (response.isSuccessful) {
                        _list.value = response.body() ?: Movies(0,emptyList())
                    } else {
                        Log.d("MovieApi", "onResponse: failed fetch data ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<Movies>, t: Throwable) {
                    Log.d("MovieApi", "onFailure: failed fetch data, check your internet connection ${t.message}")
                }
            })
        }
    }

}