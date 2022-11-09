package com.example.wisechoice

import android.icu.lang.UCharacter.LineBreak
import android.view.RoundedCorner
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.material3.Button

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wisechoice.ui.theme.*
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun Grades(userId: Int?)
{
    Box(modifier = Modifier
            .background(purple_800)
            .fillMaxSize())
    {
        Column(){
            //the nav part
            Row(
                modifier= Modifier
                        .height(80.dp)
                        .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Spacer(modifier = Modifier.width(20.dp))
             IconButton(onClick = { /*TODO*/ },
             modifier = Modifier
                     .clip(CircleShape)
                     .background(purple_50)
                     .width(40.dp)
                     .height(40.dp)
                     .border(2.dp, Color(0xFFF6F2F6), CircleShape)
             ) {
                 Icon(imageVector =Icons.Default.ArrowBack , contentDescription = "", tint= Color(0xFF301934))
             }
                Spacer(modifier = Modifier.width(50.dp))
                Text(text = "KCSE results",
                    modifier = Modifier
                            .width(190.dp)
                            .height(70.dp)
                            .padding(20.dp),
                    color= Color(0xFFF6F2F6),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,

                )
            }

            //The box part
            Row(modifier= Modifier
                    .height(80.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                 ) {
                Spacer(modifier = Modifier.width(15.dp))
                Card(modifier = Modifier
                        .background(purple_50)
                        .padding(15.dp)
                        .width(330.dp)
                    ) {
                    Text(
                        text = "Fill in your KCSE results",
                        modifier = Modifier
                                .background(purple_50)
                                .align(Alignment.CenterVertically)
                                .width(200.dp),
                        fontSize = 10.sp,
                        textAlign = TextAlign.Center,
                        color = Color(0xFF301934)
                    )
                }

            }
            Spacer(modifier = Modifier.height(20.dp))
            //The content part
            Row(
                modifier = Modifier
                        .height(800.dp)
                        .fillMaxWidth()
                        .background(purple_50),
                  horizontalArrangement = Arrangement.Center
            ) {
                Column {
                    Card(modifier = Modifier
                            .background(Color.Transparent)//this means white
                            .padding(30.dp)
                            .width(330.dp)
                            .height(120.dp)
                            .shadow(20.dp)) {
                        Column(modifier = Modifier.padding(15.dp)) {
                            Text(
                                    text = "Your Grades:",
                                    color = Color(0xFF2E2E2E),
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                            )

                            Row() {
                                Text(
                                        text = "English:A",
                                        color = Color(0xFFACACAC),
                                        fontSize = 12.sp
                                )
                                Spacer(modifier = Modifier.width(1.dp))
                                Text(
                                        text = "| Kiswahili :A",
                                        color = Color(0xFFACACAC),
                                        fontSize = 12.sp

                                )
                                Spacer(modifier = Modifier.width(1.dp))
                                Text(
                                        text = "| Physics :A |",
                                        color = Color(0xFFACACAC),
                                        fontSize = 12.sp
                                )
                            }
                            Row() {
                                Text(
                                        text = "Chemistry:A",
                                        color = Color(0xFFACACAC),
                                        fontSize = 10.sp
                                )
                                Spacer(modifier = Modifier.width(5.dp))
                                Text(
                                        text = "| History :A",
                                        color = Color(0xFFACACAC),
                                        fontSize = 12.sp
                                )
                                Spacer(modifier = Modifier.width(5.dp))
                                Text(
                                        text = "| Geography :A |",
                                        color = Color(0xFFACACAC),
                                        fontSize = 12.sp
                                )
                            }

                            Row(modifier = Modifier
                                    .height(30.dp)
                                    .fillMaxWidth(),
                                    horizontalArrangement = Arrangement.End)
                            {
                                IconButton(onClick = { /*TODO*/ },
                                        modifier = Modifier
                                                .clip(CircleShape)
                                                .background(purple_100)
                                                .width(30.dp)
                                                .height(30.dp)
                                                .border(2.dp, Color(0xFFF6F2F6), CircleShape)

                                ) {
                                    Icon(imageVector = Icons.Default.Edit, contentDescription = "", tint = Color(0xFFFFFFFF), modifier = Modifier
                                            .height(15.dp)
                                            .width(20.dp))
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier
                            .fillMaxWidth()
                            .height(30.dp))
                    Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth())
                    {
                        Divider(color = Color(0xFFACACAC), thickness = 3.dp, modifier = Modifier
                                .padding(20.dp)
                                .width(330.dp))
                    }
                    Spacer(modifier = Modifier
                            .fillMaxWidth()
                            .height(30.dp))
                    Row() {
                        Spacer(modifier = Modifier
                                .width(50.dp))
                        Column()
                        {
                            Text(
                                    text = "Subject",
                                    modifier = Modifier,
                                    color = Color(0xFF2E2E2E),
                                    fontSize = 14.sp,
                                    textAlign = TextAlign.Center

                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            OutlinedButton(onClick = { /*TODO*/ }, shape = RoundedCornerShape(5.dp), modifier = Modifier
                                    .height(40.dp)
                                    .width(300.dp)) {
                                Row(horizontalArrangement = Arrangement.SpaceBetween,
                                        modifier = Modifier.fillMaxWidth()) {
                                    Text(
                                            text = "Mathematics",
                                            modifier = Modifier,
                                            color = Color(0xFF2E2E2E),
                                            fontSize = 18.sp,
                                            textAlign = TextAlign.Center

                                    )
                                    Icon(
                                            imageVector = Icons.Default.ArrowDropDown,
                                            contentDescription = "",
                                            tint = Color(0xFF301934)
                                    )
                                }
                            }


                            Spacer(modifier = Modifier.height(5.dp))
                            Text(
                                    text = "Grade",
                                    modifier = Modifier,
                                    color = Color(0xFF2E2E2E),
                                    fontSize = 14.sp,
                                    textAlign = TextAlign.Center

                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            OutlinedButton(onClick = { /*TODO*/ }, shape = RoundedCornerShape(5.dp), modifier = Modifier
                                    .height(40.dp)
                                    .width(300.dp)) {
                                Row(horizontalArrangement = Arrangement.SpaceBetween,
                                        modifier = Modifier.fillMaxWidth()) {
                                    Text(
                                            text = "A",
                                            modifier = Modifier,
                                            color = Color(0xFF2E2E2E),
                                            fontSize = 18.sp,
                                            textAlign = TextAlign.Center

                                    )
                                    Icon(
                                            imageVector = Icons.Default.ArrowDropDown,
                                            contentDescription = "",
                                            tint = Color(0xFF301934)
                                    )
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp))
                    Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {


                        Column()
                        {
                            Button(onClick = { /*TODO*/ },
                                    colors = androidx.compose.material3.ButtonDefaults.buttonColors(androidx.compose.material3.MaterialTheme.colorScheme.secondary), modifier = Modifier.width(200.dp)) {
                                Text(
                                        text = "ADD",
                                        modifier = Modifier,
                                        color = Color(0xFFFFFFFF),
                                        fontSize = 18.sp,
                                        textAlign = TextAlign.Center

                                )
                            }

                        }
                    }
                }
            }

        }

    }
}



@Preview
@Composable
fun PreviewGradeScreen()
{
    GradeNewScreen()
}
