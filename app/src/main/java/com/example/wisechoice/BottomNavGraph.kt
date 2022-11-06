package com.example.wisechoice

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun BottomNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Explore.route
    ){
        composable(route = BottomBarScreen.Explore.route){
            ExplorePage()
        }
        composable(route = BottomBarScreen.MyCourses.route){
            Login()
        }
        composable(route = BottomBarScreen.Profile.route){
            Profile()
        }

    }
}