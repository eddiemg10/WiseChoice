package com.example.wisechoice

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ContentAlpha
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.wisechoice.sampledata.CoursesData
import com.example.wisechoice.ui.theme.WiseChoiceTheme


//class Explore: ComponentActivity(){
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            WiseChoiceTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    ExplorePage()
//                }
//            }
//        }
//    }
//}

data class Course(val id: Int, val name: String, val university: String, val star: String, val pic: String)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExplorePage(navController: NavHostController = rememberNavController()){

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
        ) {
            Heading("Explore")
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(20.dp))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                PrimaryButton("Recommend course to me", {/*TODO*/})
            }


            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(10.dp))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                PrimaryButton("Search Courses", {/*TODO*/})
            }

            Box(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp))
                LazyVerticalGrid(
                    cells = GridCells.Adaptive(180.dp),
                    contentPadding = PaddingValues(
                        bottom = 100.dp
                    ),
                    content = {
                        CoursesData.explore.map { item { CourseCard(it, navController) } }
                    },
                )


            }

        }

    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExploreCoursesList(courses: List<Course>){
    Spacer(modifier = Modifier
        .fillMaxWidth()
        .height(10.dp))
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Cyan),
        horizontalArrangement = Arrangement.SpaceBetween,
        content = {
            courses.map { item { CourseCard(it) } }
        },
    )
}

@Preview(showBackground = true)
@Preview(name="Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true)
@Composable
fun showExplorePreview(){
    WiseChoiceTheme {
        Surface{
            ExplorePage()
        }
    }
}
