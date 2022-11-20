package com.example.wisechoice

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument

@Composable
fun BottomNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Explore.route
    ){
        composable(route = Screen.SplashScreen.route){
            SplashScreen(navController = navController)
        }
        composable(route = BottomBarScreen.Explore.route){
            ExplorePage(navController = navController)
        }
        composable(route = BottomBarScreen.MyCourses.route){
            StarredCourses()
        }
        composable(route = BottomBarScreen.Profile.route){
            Profile(navController = navController)
        }

        exploreNavGraph(navController = navController)
        profileNavGraph(navController = navController)

    }
}

fun NavGraphBuilder.exploreNavGraph(navController: NavHostController){
    navigation(
        route = Graph.UNIVERSITIES,
        startDestination = Screen.Universities.route
    ){
        composable(
            route = Screen.Universities.route,
            arguments = listOf(navArgument("course"){
                type = NavType.IntType
            })
        ){
            val courseId = it.arguments?.getInt("course")
            Universities(courseId)
        }
    }
}

fun NavGraphBuilder.profileNavGraph(navController: NavHostController){
    navigation(
        route = Graph.PROFILE,
        startDestination = Screen.Holland.route
    ){
        composable(
            route = Screen.Holland.route,
            arguments = listOf(navArgument("user"){
                type = NavType.IntType
            })
        ){
            val userId = it.arguments?.getInt("user")
            HollandTest(userId)
        }

        composable(
            route = Screen.Grades.route,
            arguments = listOf(navArgument("user"){
                type = NavType.IntType
            })
        ){
            val userId = it.arguments?.getInt("user")
            Grades(userId)
        }
    }
}