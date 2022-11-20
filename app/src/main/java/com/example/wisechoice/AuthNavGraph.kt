package com.example.wisechoice

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation

fun NavGraphBuilder.authNavGraph(navController: NavHostController){
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = Screen.SplashScreen.route
    ){
        composable(route = Screen.SplashScreen.route){
            SplashScreen(navController = navController)
        }

        composable(route = Screen.Login.route){
            Login(navController = navController)
        }

        composable(route = Screen.Registration.route){
            Register(navController = navController)
        }
    }
}