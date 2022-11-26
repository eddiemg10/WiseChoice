package com.example.wisechoice

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.transform.RoundedCornersTransformation
import com.example.wisechoice.ui.theme.white

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

//@Composable
//fun ButtonwithIcon(text: String, handler: ()->Unit, icon: Icon){
//    Button(
//        onClick = handler,
//        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary),
//        shape = RoundedCornerShape(20.dp),
//        modifier = Modifier.width(150.dp)
//    ) {
//        Icon(icon, "")
//        Text(
//            text= text,
//            style = MaterialTheme.typography.labelMedium,
//            color = MaterialTheme.colorScheme.onPrimary
//        )
//    }
//}




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
                navHostController.navigate(route = Screen.Universities.passId(course.name))
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

        var showMenu by remember { mutableStateOf(false) }
        val context = LocalContext.current

        DropdownMenu(expanded = showMenu, modifier = Modifier.background(MaterialTheme.colorScheme.surface),
            onDismissRequest = { showMenu = false }
        ) {
            DropdownMenuItem(onClick = { Toast.makeText(context, "Course has been starred", Toast.LENGTH_SHORT).show()}) {
                Text(text = "Star Course",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }

        Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable(
            interactionSource = MutableInteractionSource(),
            indication = null,
            onClick = {showMenu = !showMenu}
        )
            ){
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
        modifier = Modifier.padding(top = 10.dp).fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(modifier = Modifier.weight(2f), horizontalAlignment = Alignment.CenterHorizontally){
                CardImage(url = course.pic)

            }

            Spacer(
                modifier = Modifier
                    .height(10.dp)
                    .width(10.dp)
            )
            Column(
                modifier = Modifier.padding(top = 10.dp).weight(2f),
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
fun PersonalityFilteredCourses(hollandCourse: HollandCourse){

    Row(modifier = Modifier.fillMaxWidth(0.9f).height(10.dp)){
        Column(modifier = Modifier.fillMaxHeight().background(MaterialTheme.colorScheme.primary).weight(hollandCourse.match.toFloat())){

        }
        Column(modifier = Modifier.fillMaxHeight().background(white).weight(5.1f-hollandCourse.match.toFloat())){

        }
    }

    Spacer(
        modifier = Modifier
            .height(10.dp)
            .fillMaxWidth()
    )
    Column(horizontalAlignment = Alignment.Start, modifier = Modifier.fillMaxWidth(0.9f)) {


        Row (horizontalArrangement = Arrangement.Start){

            Text(
                text = hollandCourse.hollandCode.code,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(
                modifier = Modifier
                    .width(6.dp)
                    .fillMaxWidth()
            )
            Icon(
                imageVector = Icons.Outlined.Info,
                contentDescription = "Info",
                modifier = Modifier.size(17.dp),
                tint = MaterialTheme.colorScheme.primary
            )
        }
        Text(
            text = hollandCourse.label,
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Light,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
    Spacer(
        modifier = Modifier
            .height(20.dp)
            .fillMaxWidth()
    )

    Column(
        content = {

            for(course in hollandCourse.courses){
                StarredCourseCard(course)
            }

        },
        horizontalAlignment = Alignment.CenterHorizontally
    )

    Spacer(
        modifier = Modifier
            .height(30.dp)
            .fillMaxWidth()
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



@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchBar() {
    var searchTerm by remember { mutableStateOf(TextFieldValue("")) }
    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = searchTerm,
        onValueChange = { searchTerm = it},
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Search Icon",
                tint = MaterialTheme.colorScheme.onBackground.copy(
                    alpha = ContentAlpha.medium
                )
            )
        },
        trailingIcon = {
            IconButton(onClick = {
                if (searchTerm == TextFieldValue("")){
                    focusManager.clearFocus()
                }
                else{
                    searchTerm = TextFieldValue("")
                }

            }) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "Close Icon",
                    tint = MaterialTheme.colorScheme.onBackground.copy(
                        alpha = ContentAlpha.medium
                    )
                )
            }
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = MaterialTheme.colorScheme.onBackground.copy(
                alpha = ContentAlpha.medium
            ),
            focusedBorderColor = MaterialTheme.colorScheme.onBackground,
            cursorColor = MaterialTheme.colorScheme.onBackground,
            backgroundColor = MaterialTheme.colorScheme.background,
            textColor = MaterialTheme.colorScheme.onBackground
        )
    )
}


@Composable
@Preview(showBackground = true)
fun showBadge(){
    Badge("2022 | 22.56")
}
