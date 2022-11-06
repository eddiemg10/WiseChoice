package com.example.wisechoice

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
){
    object Explore: BottomBarScreen(
        route = "explore",
        title = "Explore",
        icon = Icons.Default.Search
    )
    object MyCourses: BottomBarScreen(
        route = "mycourses",
        title = "My courses",
        icon = Icons.Default.List
    )
    object Profile: BottomBarScreen(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.Person
    )
}
