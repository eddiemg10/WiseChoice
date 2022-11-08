package com.example.wisechoice

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.TextButton
import androidx.compose.material.contentColorFor
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wisechoice.ui.theme.*
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun Grades(userId: Int?)
{
    Box(modifier = Modifier
        .background(purple_900)
        .fillMaxSize())
    {
        Column{
            GradeScreenTop()
            GradeButton()
            GradeContent()
        }
    }
}

@Composable
fun GradeScreenTop()
{
    Row(horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)) {

        Button(
            onClick = { /*TODO*/
            },
            shape = CircleShape,
            modifier = Modifier
                .background(white)
                .size(30.dp),
        ) {
            // Icon(painterResource(id = R.drawable.ic_launcher_background ))
            //add the arrow icon
            Text(text = "Back thingy")
        }
        Text(text = "KCSE results", modifier = Modifier.background(white))
    }
}

@Composable
fun GradeButton()
{
    Button(onClick = { /*TODO*/ }, modifier = Modifier.background(purple_100)) {
        Text(text = "Fill in your KCSE results",
            modifier = Modifier
                .padding(12.dp)
                .background(purple_800) )
    }
}

@Composable
fun GradeContent()
{
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(grey_50))
    {
        Column {
            //the Grades card information
            Row(
                modifier = Modifier
                    .padding(12.dp)
                    .shadow(2.dp),
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Row {
                    Column {
                        Text(text = "Your Grades:")
                        Text(text = "English: A|Kiswahili: A|Physics: A|")
                        Text(text = "Chemistry: A|History: A|Geography: A|")
                    }
                }
                Row {
                    Button(onClick = { /*TODO*/ }, modifier = Modifier.background(purple_100)) {
                        //Icon
                        Text(text = "Pen thingy")
                    }
                }

            }

            // Spacer(modifier = Modifier.padding(3.dp))
            Row {
                Text(text = "Line thingy")
            }

            Row(modifier = Modifier.padding(3.dp)) {
                Column() {
                    //the subject part
                    Text(text = "Subject")
                    Button(onClick = { /*TODO*/ }) {
                        Row(horizontalArrangement = Arrangement.SpaceBetween) {
                            Text(text = "Mathematics")
                            // Icon
                        }
                    }

                    //the grade part
                    Text(text = "Grade")
                    Button(onClick = { /*TODO*/ }) {
                        Row(horizontalArrangement = Arrangement.SpaceBetween) {
                            Text(text = "A")
                            // Icon
                        }
                    }

                    Spacer(modifier = Modifier.padding(3.dp))

                    Row(horizontalArrangement = Arrangement.Center) {
                        Button(onClick = { /*TODO*/ }, modifier = Modifier.background(purple_900)) {
                            Text(text = "ADD", modifier = Modifier.background(purple_100))
                        }
                    }
                }
            }
        }


    }
}
