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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
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
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(MaterialTheme.colorScheme.secondary)
                .padding(horizontal = 20.dp)

                .fillMaxSize()


        ) {
            Header("CREATE ACCOUNT")

            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(14.dp))

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
                .height(70.dp))

            RegisterButton(navController)
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(8.dp))

            /*footer("Already have an account? Sign In")*/
            val click = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Normal,
                    )
                ){
                    append("Already have an account? ")
                }
                withStyle(
                    style = SpanStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                ){
                    append("Login")
                }

            }
            ClickableText(
                text = click,
                onClick = {
                    navController.navigate(Screen.Login.route)
                          },

                )
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
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        contentPadding = PaddingValues(16.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colorScheme.primary,
            contentColor = Color.White
        ),



        ) {
        Text(
            text = "Create Account",
            color = Color.White,

            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,

            )
    }
}

@Composable
fun Header(heading: String){
    val imageModifier = Modifier
        .size(80.dp)

    Text(
        text = "WISE CHOICE",
        color = Color.White,
        style = MaterialTheme.typography.displaySmall,
        fontWeight = FontWeight.Normal,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
    )

    Image(painter = painterResource(id = R.drawable.ic_graduation_cap_solid),
        contentDescription ="" ,
        colorFilter = ColorFilter.tint(Color.White) ,
        modifier = imageModifier
    )

    Text(
        color = Color.White,
        text = heading,
        style = MaterialTheme.typography.headlineSmall,

        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.dp)
    )
}

@Composable
fun footer(text: String){
    ClickableText(text = AnnotatedString(text), onClick = {},  )

}
/* Mi illamo Roberto*/
/*
@Composable
fun Footer(){
    ClickableText(text = AnnotatedString("Already have an account? Sign In"), onClick = TODO() )
}
*/



