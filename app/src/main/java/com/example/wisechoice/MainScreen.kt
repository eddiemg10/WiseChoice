package com.example.wisechoice

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(){
    val navController = rememberNavController()
    
    Scaffold(bottomBar = {BottomBar(navController = navController)}
    ) {
//        RootNavigationGraph(navController = navController)

        BottomNavGraph(navController = navController)
    }
}

@Composable
fun BottomBar(navController: NavHostController){
    val screens = listOf(
        BottomBarScreen.Explore,
        BottomBarScreen.MyCourses,
        BottomBarScreen.Profile,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    BottomNavigation(
        backgroundColor = MaterialTheme.colorScheme.secondary,
        contentColor = MaterialTheme.colorScheme.onSecondary
    ) {
        screens.forEach{screen ->
            AddItem(screen = screen, currentDestination = currentDestination, navController = navController)
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController,
){
    BottomNavigationItem(
        label = {
            Text(
                text= screen.title,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSecondary
                ) },
        icon = {
            Icon(imageVector = screen.icon,
                contentDescription = "Navigation Icon",
//                tint = MaterialTheme.colorScheme.onSecondary
            )
        },
        selected = currentDestination?.hierarchy?.any{
            it.route == screen.route
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.route)
        }
    )

}