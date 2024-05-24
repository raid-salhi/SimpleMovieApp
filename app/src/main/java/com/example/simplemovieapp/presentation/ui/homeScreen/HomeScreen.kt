package com.example.simplemovieapp.presentation.ui.homeScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.simplemovieapp.data.model.Movies
import com.example.simplemovieapp.presentation.componants.MovieItem
import com.example.simplemovieapp.presentation.navigation.Screen

@Composable
fun HomeScreen(
    navController: NavHostController,
    homeScreenViewModel: HomeScreenViewModel
) {
    val moviesList = remember {
        mutableStateOf(Movies(0,emptyList()))
    }
    moviesList.value = homeScreenViewModel.movieList.value

    Column (
        modifier = Modifier.fillMaxSize()
    ){
        if (moviesList.value.page==0)
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxSize(0.4f)
                    .padding(top = 100.dp)
            )
        else
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ){
                items(items = moviesList.value.results){ movie ->
                    MovieItem(
                        movie = movie,
                        onClick={
                            navController.navigate(Screen.Details(movie.id))
                        }
                    )
                }
            }
    }
}


