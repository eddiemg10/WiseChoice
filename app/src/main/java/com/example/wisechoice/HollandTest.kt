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
    import androidx.compose.ui.unit.dp
    import com.example.wisechoice.ui.theme.*
    import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

    @Composable
    fun HollandScreen()
    {
        Box(modifier = Modifier
            .background(purple_900)
            .fillMaxSize())
        {
            Column{
                HollandScreenTop()
                HollandButton()
                HollandContent()
            }
        }
    }

    @Composable
    fun HollandScreenTop()
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
            Text(text = "Holland Code Test", modifier = Modifier.background(white))
        }
    }

    @Composable
    fun HollandButton()
    {
        Button(onClick = { /*TODO*/ }, modifier = Modifier.background(purple_100)) {
            Text(text = "Answer the following questions with how much you would like/",
                modifier = Modifier
                    .padding(12.dp)
                    .background(purple_800) )
            Text(text = "dislike the specified activities",
                modifier = Modifier
                    .padding(12.dp)
                    .background(purple_800) )
        }
    }

    @Composable
    fun HollandContent()
    {
        Box(modifier = Modifier
            .fillMaxWidth()
            .background(grey_50))
        {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Column {
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Dislike", modifier = Modifier.background(purple_100))
                    }
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Slightly dislike", modifier = Modifier.background(purple_100))
                    }
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Neutral", modifier = Modifier.background(purple_100))
                    }
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Slightly Enjoy", modifier = Modifier.background(purple_100))
                    }
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Enjoy", modifier = Modifier.background(purple_100))
                    }

                    Spacer(modifier = Modifier.padding(2.dp))

                    Row() {
                        Button(onClick = { /*TODO*/ }) {
                            Text(text = "1/20")
                        }
                        Button(onClick = { /*TODO*/ }) {
                            Text(text = "NEXT")
                        }
                    }
                }
            }
        }
        //footbar
        Row(modifier = Modifier.background(purple_200)) {
            Column() {
                Button(onClick = { /*TODO*/ }) {
                    Column()
                    {
                        //Icon
                        Text(text = "Explore")
                    }

                }
            }
            Column() {
                Button(onClick = { /*TODO*/ }) {
                    Column()
                    {
                        //Icon
                        Text(text = "My courses")
                    }

                }
            }
            Column() {
                Button(onClick = { /*TODO*/ }) {
                    Column()
                    {
                        //Icon
                        Text(text = "Profile")
                    }

                }
            }
        }
    }
