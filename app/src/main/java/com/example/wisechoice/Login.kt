package com.example.wisechoice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wisechoice.ui.theme.WiseChoiceTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WiseChoiceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Login()
                }
            }
        }
    }
}

@Composable
fun Login(){

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondary)
            .padding(16.dp)

    ) {
        Header("LOGIN")

        Email()
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(7.dp))
        Password("Password")
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(7.dp))
        signinButton(navController = navController)
        /*TODO: Implement Sign Up */
        Button(
            onClick = {
                navController.navigate(Screen.Registration.route)
            },
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(text = "Create Account")
        }
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(8.dp))
        footer("Don't have an account? Register here")


    }
}

@Preview(showBackground = true)
@Composable
fun showLoginPreview(){
    Login(navController = rememberNavController())
}

@Composable
fun Email(){
    val emailState = remember { mutableStateOf(TextFieldValue())}
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = emailState.value ,
        onValueChange ={  emailState.value = it },
        label = { Text(text = "Email Address")},
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(8.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
    )
}

@Composable
fun Password(string: String){
    val passwordState = remember { mutableStateOf(TextFieldValue())}
    val showPassword = remember {
        mutableStateOf(false)
    }
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = passwordState.value ,
        onValueChange ={ passwordState.value =  it },
        label = { Text(text = string)},
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(8.dp),
        visualTransformation = if (showPassword.value){
            VisualTransformation.None
        }else{
                PasswordVisualTransformation()
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            if (showPassword.value){
                IconButton(onClick = { showPassword.value = false }) {
                    Icon(
                        imageVector = Icons.Filled.Visibility,
                        contentDescription = stringResource(id = R.string.hide_password),
                    )

                }
            }else{
                IconButton(onClick = { showPassword.value = true }) {
                    Icon(
                        imageVector = Icons.Filled.VisibilityOff,
                        contentDescription = stringResource(id =R.string.show_password),
                    )
                }
            }

        }
    )
}

@Composable
fun signinButton(){
    Button(
        onClick = {
                  navController.popBackStack()
                  navController.navigate(Graph.EXPLORE)
                  },
        modifier = Modifier
            .fillMaxWidth(fraction = 0.8F)
            .padding(horizontal = 12.dp),
        contentPadding = PaddingValues(16.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colorScheme.primary,
            contentColor = Color.White
        ),



        ) {
        Text(text = "Sign In")
    }
}