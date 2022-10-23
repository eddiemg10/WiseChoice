package com.example.wisechoice

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wisechoice.ui.theme.WiseChoiceTheme


class Explore: ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WiseChoiceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Login()
                }
            }
        }
    }
}

@Composable
fun ExplorePage(){

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column {
            Heading("Explore")
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(20.dp))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                PrimaryButton("Recommend course to me", {/*TODO*/})
            }

            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(20.dp))

            Text(text = "OR", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(20.dp))

            Surface(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(56.dp),

            ){

            }
        }
    }

}

@Preview(showBackground = true)
@Preview(name="Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true)
@Composable
fun showExplorePreview(){
    WiseChoiceTheme {
        Surface{
            ExplorePage()

        }
    }
}
