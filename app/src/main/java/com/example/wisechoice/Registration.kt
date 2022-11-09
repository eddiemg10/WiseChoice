package com.example.wisechoice

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wisechoice.ui.theme.WiseChoiceTheme

//class RegistrationActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            WiseChoiceTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .background(MaterialTheme.colorScheme.primary),
//                    color = MaterialTheme.colorScheme.background,
//                ) {
//                    Register()
//                }
//            }
//        }
//    }
//}

@Composable
fun Register(navController: NavController){
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .background(MaterialTheme.colorScheme.secondary).padding(horizontal = 20.dp)

                .fillMaxSize()


        ) {
            Header("CREATE ACCOUNT")

            Username()
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(7.dp))
            Email()
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(7.dp))
            Password("Password")
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(7.dp))
            Password("Confirm Password")

            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(7.dp))
            RegisterButton(navController)
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(8.dp))

            footer("Already have an account? Sign In")
        }
    }

}

@Preview
@Composable
fun registrationPreview() {
    WiseChoiceTheme {
        Surface {
            Register(navController = rememberNavController())

        }
    }
}
@Composable
fun Username(){
    val emailState = remember { mutableStateOf(TextFieldValue())}
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = emailState.value ,
        onValueChange ={  emailState.value = it },
        label = { Text(text = "Username")},
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
fun RegisterButton(navController: NavController){
    Button(
        onClick = {
            navController.navigate(Screen.Login.route)
                  },
        modifier = Modifier.fillMaxWidth(fraction = 0.8F).padding(12.dp),
        contentPadding = PaddingValues(16.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colorScheme.primary,
            contentColor = Color.White
        ),



        ) {
        Text(text = "Sign Up")
    }
}

@Composable
fun Header(heading: String){
    val imageModifier = Modifier.size(250.dp).padding(horizontal = 40.dp)


    Heading(title = heading)
    Image(painter = painterResource(id = R.drawable.ic_graduation_cap_solid),  contentDescription ="" , modifier = imageModifier)

}

@Composable
fun footer(text: String){
    ClickableText(text = AnnotatedString(text), onClick = {},  )
}

/*
@Composable
fun Footer(){
    ClickableText(text = AnnotatedString("Already have an account? Sign In"), onClick = TODO() )
}
*/



