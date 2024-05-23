package com.example.simplemovieapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.simplemovieapp.presentation.ui.detailsScreen.DetailsScreen
import com.example.simplemovieapp.presentation.ui.detailsScreen.DetailsScreenViewModel
import com.example.simplemovieapp.presentation.ui.homeScreen.HomeScreen
import com.example.simplemovieapp.presentation.ui.homeScreen.HomeScreenViewModel

@Composable
fun AppNavigation (){
    val navController = rememberNavController()
    val homeScreenViewModel : HomeScreenViewModel = hiltViewModel()
    val detailsScreenViewModel : DetailsScreenViewModel = hiltViewModel()
    NavHost(navController = navController, startDestination = Screen.Home){
        composable<Screen.Home>{
            HomeScreen(navController,homeScreenViewModel)
        }
        composable<Screen.Details>{
            val detail = it.toRoute<Screen.Details>()

            DetailsScreen(navController,detailsScreenViewModel,id=detail.id)
        }
    }
}