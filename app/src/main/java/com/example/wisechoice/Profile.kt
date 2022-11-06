package com.example.wisechoice

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.wisechoice.sampledata.UsersData
import com.example.wisechoice.ui.theme.WiseChoiceTheme
import com.example.wisechoice.ui.theme.pink_heavy


data class User(val id: String, val fname: String, val lname: String, val email: String, val holland: String, val grades: Grades )
data class Grades(val math: String, val eng: String, val swa: String, val phy: String, val chem: String, val hist: String,val geo: String, )

@Composable
fun Profile(){

    val user = UsersData.user1
    Column(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)){
        Surface(
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.25f)
        ){
            Text(
                color = MaterialTheme.colorScheme.onSecondary,
                text = "Personal Profile",
                style = MaterialTheme.typography.displaySmall,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 20.dp)

            )

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally

        ){

            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.offset(y=-(40.dp))) {


                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .background(
                            pink_heavy,
                            shape = CircleShape,
                        )
                        .width(80.dp)
                        .height(80.dp)
                ) {
                    Text(
                        text = user.fname[0].toString(),
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        style = MaterialTheme.typography.displayLarge,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(4.dp),
                    )
                }

                Row(){
                    Text(text = user.fname+" "+user.lname,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurface
                        )
                    Spacer(modifier = Modifier
                        .width(5.dp))
                    Icon(imageVector = Icons.Default.Edit,
                        contentDescription ="Info",
                        modifier = Modifier.size(20.dp),
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
                Text(text = user.email,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

            }

            OutlinedButton(onClick = { /*TODO*/ },
                modifier= Modifier
                    .size(100.dp)
                    .offset(x = 110.dp, y = 15.dp)
                    .zIndex(3f),  //avoid the oval shape
                shape = CircleShape,
                border= BorderStroke(3.dp, Color.White),
                contentPadding = PaddingValues(0.dp),  //avoid the little icon
                colors = ButtonDefaults.outlinedButtonColors(backgroundColor = MaterialTheme.colorScheme.primary , contentColor =  MaterialTheme.colorScheme.onPrimary),
            ) {
                Text("Retake Holland Test" ,
                    color = MaterialTheme.colorScheme.onPrimary,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodySmall,

                    )
            }

            Column(
                modifier = Modifier
                    .offset(y = -(50.dp))
                    .fillMaxWidth(0.8f)
                    .clip(RoundedCornerShape(10.dp))
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(top = 40.dp, bottom = 60.dp, start = 15.dp, end = 15.dp),
            ){
                Row {

                    Column() {
                        Text(
                            text = "Holland Code",
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface

                        )
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(6.dp)
                        )
                        Row {

                            Text(
                                text = user.holland,
                                style = MaterialTheme.typography.bodySmall,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Icon(
                                imageVector = Icons.Outlined.Info,
                                contentDescription = "Info",
                                modifier = Modifier.size(17.dp),
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    }


                }

                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp))

                Column(){
                    Row (verticalAlignment = Alignment.CenterVertically){

                        Text(
                            text = "Grades",
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Spacer(modifier = Modifier
                            .width(5.dp))
                        Icon(imageVector = Icons.Default.Edit,
                            contentDescription ="Info",
                            modifier = Modifier.size(20.dp),
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                    Spacer(modifier = Modifier
                        .fillMaxWidth()
                        .height(6.dp))
                    Text(
                        text = "Maths: ${user.grades.math} | English: ${user.grades.eng} |" +
                                "Kiswahili: ${user.grades.swa} | Physics: ${user.grades.phy} |" +
                                " Chemistry: ${user.grades.chem} | History: ${user.grades.hist} | Geography: ${user.grades.geo} ",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
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
fun ShowProfile(){
    WiseChoiceTheme {
        Surface{
            Profile()

        }
    }
}