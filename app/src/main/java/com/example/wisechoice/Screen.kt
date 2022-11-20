package com.example.wisechoice

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val route: String,
){

    object SplashScreen: Screen("splash"){
    }
    object Login: Screen("login")

    object Registration: Screen("registration")

    object Universities: Screen("universities/{course}"){
        fun passId(course: Int): String{
            return "universities/$course"
        }
    }

    object Holland: Screen("holland/{user}"){
        fun passId(user: Int): String{
            return "holland/$user"
        }
    }

    object Grades: Screen("grades/{user}"){
        fun passId(user: Int): String{
            return "grades/$user"
        }
    }
}

