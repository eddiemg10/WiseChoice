package com.example.wisechoice

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.transform.RoundedCornersTransformation

@Composable
fun Heading(title: String){
    Text(
        color = MaterialTheme.colorScheme.onBackground,
        text = title,
        style = MaterialTheme.typography.displaySmall,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
    )
}

@Composable
fun SubHeading(title: String){
    Text(
        color = MaterialTheme.colorScheme.onBackground,
        text = title,
        style = MaterialTheme.typography.bodyLarge,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
    )
}


@Composable
fun PrimaryButton(text: String, handler: ()->Unit){
    Button(
        onClick = handler,
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.fillMaxWidth(0.8F)
    ) {
        Text(
            text= text,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Composable
fun ButtonwithIcon(text: String, handler: ()->Unit){
    Button(
        onClick = handler,
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary),
        shape = RoundedCornerShape(8.dp),
    ) {
        Text(
            text= text,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}




@Composable
fun CardImage(url: String = "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg"){
    Box(modifier = Modifier
        .height(150.dp)
        .width(150.dp),
        contentAlignment = Alignment.Center
    ){
        val painter = rememberImagePainter(
            data = url,
            builder = {
                placeholder(R.drawable.placeholder)
                error(R.drawable.placeholder)
                crossfade(1000)
                transformations(
                    RoundedCornersTransformation(30f)
                )
            }
        )
        val painterState = painter.state
        Image(painter = painter, contentDescription ="Test Image",
                contentScale = ContentScale.Crop
            )
        if(painterState is ImagePainter.State.Loading){
            CircularProgressIndicator()
        }
    }
}

@Composable
fun CourseCard(course: Course, navHostController: NavHostController = rememberNavController()){
    Column(
        modifier = Modifier
            .padding(top = 10.dp)
            .clickable {
                navHostController.navigate(route = Screen.Universities.passId(course.id))
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        CardImage(url = course.pic)
        Spacer(modifier = Modifier
            .height(10.dp))
        Text(text = course.name,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Normal,
            color = MaterialTheme.colorScheme.onSurface

        )
        Text(text = course.university,
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Light,
            color = MaterialTheme.colorScheme.onBackground
        )
        Row(verticalAlignment = Alignment.CenterVertically){
            Icon(Icons.Rounded.Star,
                contentDescription = "Star Icon",
                modifier = Modifier.size(14.dp),
                tint = MaterialTheme.colorScheme.primary
            )
            Text(text= course.star,
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.Light,
                color = MaterialTheme.colorScheme.primary
            )
        }

    }
}


@Composable
fun StarredCourseCard(course: Course) {
    Column(
        modifier = Modifier.padding(top = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            CardImage(url = course.pic)

            Spacer(
                modifier = Modifier
                    .height(10.dp)
                    .width(10.dp)
            )
            Column(
                modifier = Modifier.padding(top = 10.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = course.name,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Normal,
                    color = MaterialTheme.colorScheme.onSurface

                )
                Text(
                    text = course.university,
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Light,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    Icon(
                        Icons.Rounded.Star,
                        contentDescription = "Star Icon",
                        modifier = Modifier.size(14.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = course.star,
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Light,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }

    Divider(color = MaterialTheme.colorScheme.primary,
        thickness = 1.dp,
    modifier = Modifier.padding(10.dp)
    )
}


@Composable
fun UniversityCard(university: University, navHostController: NavHostController = rememberNavController()){
    Column {
        Row(
            modifier = Modifier
                .padding(top = 10.dp, start = 20.dp, end = 20.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically

        ) {

            Column(
                modifier = Modifier.fillMaxWidth(0.6f).padding(end = 17.dp)
            ) {

                Text(
                    text = university.name,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Normal,
                    color = MaterialTheme.colorScheme.onBackground

                )
                Text(
                    text = "Recent cutoff points",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Light,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                )
                Row() {
                    LazyRow {
                        university.cutoff.map {
                            item {
                                val text = "${it.year} | ${it.cutoff}"
                                Badge(text)
                            }
                        }
                    }
                }
            }

            Column {
                CardImage(url = university.logo)
            }

        }
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
        Column(modifier=Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

            Box(
                modifier = Modifier.background(MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f))
                    .fillMaxWidth(0.9f)
                    .height(1.dp)
                    .clip(RoundedCornerShape(50.dp))
            )
        }
    }
}

@Composable
fun Badge(text: String){
    Box(modifier = Modifier
        .padding(all=7.dp)
        .background(color = MaterialTheme.colorScheme.surface,
            shape = RoundedCornerShape(50.dp)
        ),


    ){
        Text(text=text,
            modifier = Modifier.padding(start = 7.dp, end = 7.dp, top = 3.dp, bottom = 3.dp),
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.labelSmall
            )

    }
}



@Composable
fun TextInput(){
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
                    .border(
                        BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground)
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

@Composable
@Preview(showBackground = true)
fun showBadge(){
    Badge("2022 | 22.56")
}
