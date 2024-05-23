package com.example.simplemovieapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.simplemovieapp.presentation.ui.detailsScreen.DetailsScreen
import com.example.simplemovieapp.presentation.ui.homeScreen.HomeScreen

@Composable
fun AppNavigation (){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Home){
        composable<Screen.Home>{
            HomeScreen(navController)
        }
        composable<Screen.Details>{
            val details= it.toRoute<Screen.Details>()
            DetailsScreen(navController,id=details.id)
        }
    }
}