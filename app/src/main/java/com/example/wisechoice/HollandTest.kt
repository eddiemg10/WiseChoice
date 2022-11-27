package com.example.wisechoice

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wisechoice.sampledata.holland_questions
import com.example.wisechoice.ui.theme.*
data class Questions(val number: Int, val question: String, val category: String)


@Composable
fun question_card(ques: Questions)
{
    Row {
        // Text(text = ques.number)

        Text(text = ques.question,
            modifier = Modifier
                .padding(all = 10.dp)
                .width(323.dp),
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center,
            color = Color(0xFFFFFFFF)



        )
    }
    // Text(text= ques.category)

}

@Composable
fun display_question(questions : List<Questions>)
{
    LazyRow(modifier = Modifier
        .padding(20.dp)){
        questions.map{
            item{ question_card(it)}}
    }
}

@Composable
fun HollandTest(userId: Int?)
{
    Box(modifier = Modifier
        .background(purple_800)
        .fillMaxSize())
    {
        Column() {
            //the nav part
            Row(
                modifier = Modifier
                    .height(80.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Spacer(modifier = Modifier.width(20.dp))
                IconButton(onClick = {
                },
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(purple_50)
                        .width(40.dp)
                        .height(40.dp)
                        .border(2.dp, Color(0xFFF6F2F6), CircleShape)
                ) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "", tint = Color(0xFF301934))
                }
                Spacer(modifier = Modifier.width(50.dp))
                Text(
                    text = "Holland Code Test",
                    modifier = Modifier
                        .width(210.dp)
                        .height(70.dp)
                        .padding(20.dp),
                    color = Color(0xFFF6F2F6),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
            }

            Column(
                modifier = Modifier
                    .height(80.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    modifier = Modifier
                        .background(purple_50)
                        .padding(15.dp)
                        .fillMaxWidth(0.9f),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Answer the following questions with how much you would like/dislike the specified activities",
                        style = MaterialTheme.typography.body2,
                        textAlign = TextAlign.Center,
                        color = purple_900,

                        )
                }

            }
            Spacer(modifier = Modifier
                .height(30.dp)
                .fillMaxWidth())

            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth())
            {
                Divider(color = Color(0xFFFFFFFF), thickness = 2.dp, modifier = Modifier
                    .padding(20.dp)
                    .width(330.dp))
            }

            Row(
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                display_question(holland_questions.question)

            }

            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(20.dp))

            Row(modifier = Modifier
                .height(500.dp)
                .fillMaxWidth()
                .background(purple_50)
            ) {
                Spacer(modifier = Modifier
                    .height(20.dp)
                    .background(pink_light))

                Column(modifier = Modifier.fillMaxWidth()) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Column(modifier = Modifier.padding(25.dp)) {

                        var color = remember { mutableStateOf(Color.White) }
                        var count = remember { mutableStateOf(0) }
                        Button(
                            onClick = {
                            },
                            colors = ButtonDefaults.buttonColors(androidx.compose.material3.MaterialTheme.colorScheme.primary),
                            modifier = Modifier
                                .width(400.dp)
                                .height(50.dp),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text(
                                text = "Dislike",
                                modifier = Modifier,
                                color = Color(0xFFFFFFFF),
                                fontSize = 18.sp,
                                textAlign = TextAlign.Center

                            )
                        }
                        Spacer(modifier = Modifier.height(15.dp))


                        Button(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(androidx.compose.material3.MaterialTheme.colorScheme.primary),
                            modifier = Modifier
                                .width(400.dp)
                                .height(50.dp),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text(

                                text = "Slightly dislike",

                                modifier = Modifier,
                                color = Color(0xFFFFFFFF),
                                fontSize = 18.sp,
                                textAlign = TextAlign.Center

                            )
                        }
                        Spacer(modifier = Modifier.height(15.dp))

                        Button(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(androidx.compose.material3.MaterialTheme.colorScheme.primary),
                            modifier = Modifier
                                .width(400.dp)
                                .height(50.dp),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text(

                                text = "Neutral",

                                modifier = Modifier,
                                color = Color(0xFFFFFFFF),
                                fontSize = 18.sp,
                                textAlign = TextAlign.Center

                            )
                        }


                        Spacer(modifier = Modifier.height(15.dp))

                        Button(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(androidx.compose.material3.MaterialTheme.colorScheme.background),
                            modifier = Modifier
                                .width(400.dp)
                                .height(50.dp)
                                .shadow(10.dp),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text(
                                text = "Slightly Enjoy",
                                modifier = Modifier,
                                color = Color(0xFF86608E),
                                fontSize = 18.sp,
                                textAlign = TextAlign.Center

                            )
                        }
                        Spacer(modifier = Modifier.height(15.dp))

                        Button(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(androidx.compose.material3.MaterialTheme.colorScheme.primary),
                            modifier = Modifier
                                .width(400.dp)
                                .height(50.dp)
                                .shadow(10.dp),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text(
                                text = "Enjoy",
                                modifier = Modifier,
                                color = Color(0xFFFFFFFF),
                                fontSize = 18.sp,
                                textAlign = TextAlign.Center


                            )
                        }
                        Spacer(modifier = Modifier.height(20.dp))

                        Row() {
                            Spacer(modifier = Modifier.width(90.dp))
                            Button(
                                onClick = { /*TODO*/ },
                                colors = ButtonDefaults.buttonColors(
                                    androidx.compose.material3.MaterialTheme.colorScheme.background
                                ), modifier = Modifier
                                    .width(100.dp)

                                    .background(Color.Transparent)
                            ) {
                                Text(
                                    text = "1/20",
                                    modifier = Modifier,
                                    color = Color(0xFF301934),
                                    fontSize = 18.sp,
                                    textAlign = TextAlign.Center

                                )
                            }

                            Button(
                                onClick = { /*TODO*/ },
                                colors = ButtonDefaults.buttonColors(
                                    androidx.compose.material3.MaterialTheme.colorScheme.tertiary
                                ), modifier = Modifier
                                    .width(100.dp)

                                    .background(Color.Transparent)
                            ) {
                                Text(
                                    text = "NEXT",
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




@Preview(showBackground = true)
@Composable
fun PreviewHollandNewScreen()
{
   HollandTest(1)
}