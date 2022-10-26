package com.example.wisechoice

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ContentAlpha
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

            val text = ""

            Surface(
            ){
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {


                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                        .border(BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground)
                        ),
                        value = "",
                        onValueChange = {
                            /*TODO*/
                        },
                        placeholder = {
                            Text(
                                modifier = Modifier.alpha(ContentAlpha.medium),
                                text = "Search Courses",
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        },
                        singleLine = true,
                        leadingIcon = {
                            IconButton(
                                modifier = Modifier.alpha(ContentAlpha.medium),
                                onClick = {}
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = "Search Icon",
                                    tint = MaterialTheme.colorScheme.onBackground
                                )
                            }
                        },
                        trailingIcon = {
                            IconButton(
                                onClick = {
                                    if (text.isNotEmpty()) {
                                        // Call onTextChange()
                                    } else {
                                        // Call onCloseClickedd()
                                    }
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Close,
                                    contentDescription = "Close Icon",
                                    tint = MaterialTheme.colorScheme.onBackground

                                )
                            }
                        },
                        keyboardOptions = KeyboardOptions(
                            //Change device keypad to have a search icon
                            imeAction = ImeAction.Search
                        ),
                        keyboardActions = KeyboardActions(
                            onSearch = {
                                // Call onSearchClicked(text)
                            }
                        ),
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = MaterialTheme.colorScheme.background,
                            cursorColor = MaterialTheme.colorScheme.primary,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                        ),
                        shape = RoundedCornerShape(18.dp),

                        )
                }
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
