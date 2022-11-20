package com.example.wisechoice

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.wisechoice.ui.theme.purple_200
import com.example.wisechoice.ui.theme.purple_900
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController){
    var startAnimation by remember{
        mutableStateOf(false)
    }
    val alphaAnim = animateFloatAsState(
        targetValue = if(startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000
        )
    )

    LaunchedEffect(key1 = true){
        startAnimation = true
        delay(4000)
        navController.popBackStack()
        navController.navigate(Screen.Login.route)
    }
    Splash(alpha = alphaAnim.value)
}

@Composable
fun Splash(alpha: Float){
    Column(
        modifier = Modifier
            .background(color = if (isSystemInDarkTheme()) purple_900 else purple_200)
            .fillMaxSize()
    ){
        Column (modifier = Modifier
            .fillMaxWidth()
            .weight(4f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
            ){
            Image( painter = painterResource(id = R.drawable.logo),
                contentDescription = "App Logo",
                alpha = alpha
                )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 20.dp)
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Row(){
                Text("WISE",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.displaySmall,
                    fontFamily = FontFamily(Font(R.font.montserrat_bold)),
                    color = Color.White
                )
                Spacer(
                    modifier = Modifier
                        .width(13.dp)
                )
                Text("CHOICE",
                    fontWeight = FontWeight.Thin,
                    style = MaterialTheme.typography.displaySmall,
                    fontFamily = FontFamily(Font(R.font.montserrat_light)),
                    color = Color.White



                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun showSplash(){
    Splash(1f)
}
