package com.example.wisechoice

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RootNavigationGraph(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTHENTICATION
    ){
//        bottomNavGraph(navController = navController)
        authNavGraph(navController = navController)
        composable(route = Graph.EXPLORE){
            MainScreen()
        }

    }
}

object Graph{
    const val ROOT = "root_graph"
    const val AUTHENTICATION = "auth_graph"
    const val EXPLORE = "explore_graph"
    const val UNIVERSITIES = "university_graph"
    const val PROFILE = "Profile_graph"
    const val RECOMMENDED = "recommended_graph"
}