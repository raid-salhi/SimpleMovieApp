package com.example.simplemovieapp.presentation.ui.detailsScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.simplemovieapp.data.model.Movie
import com.example.simplemovieapp.presentation.componants.ContentText
import com.example.simplemovieapp.presentation.componants.MovieImage
import com.example.simplemovieapp.presentation.componants.TitleText

@Composable
fun DetailsScreen(
    navController: NavHostController,
    detailsScreenViewModel: DetailsScreenViewModel,
    id: Int
) {

    detailsScreenViewModel.getMovie(id)
    val movie= remember {
        mutableStateOf<Movie?>(null)
    }
    movie.value = detailsScreenViewModel.movie.value

    Column (
        modifier = Modifier.fillMaxSize()
    ){
        if (movie.value==null)
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxSize(0.4f)
                    .padding(top = 100.dp)
            )
        else{
            MovieDetails(movie.value!!)
        }

    }
}

@Composable
fun MovieDetails(movie: Movie) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        MovieImage(
            modifier=Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxHeight(0.5f)
                .padding(vertical = 10.dp),
            poster=movie.poster
        )
        TitleText(
            text = movie.title,
            modifier=Modifier.padding(bottom = 20.dp)
        )
        ContentText(
            text = movie.getYear(),
            modifier=Modifier.padding(bottom = 20.dp)
        )
        ContentText(
            text = movie.overview,
            modifier=Modifier
        )
    }
}


