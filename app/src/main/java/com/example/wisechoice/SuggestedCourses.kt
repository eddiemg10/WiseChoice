package com.example.wisechoice

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.ImagePainter.State.Empty.painter
import com.example.wisechoice.sampledata.CoursesData
import com.example.wisechoice.ui.theme.WiseChoiceTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment




data class SuggestedCourses(val name: String, val university: String, val star: String, val pic: String)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SuggestedCoursesResults(navController: NavHostController){
    Box(modifier = Modifier
        .background(MaterialTheme.colorScheme.background)
        .fillMaxSize()
    ){
        Column{

            Heading("Suggested Courses")
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(15.dp))


                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {

                    Button(
                        onClick = { navController.navigate(route = Screen.PersonalityCourses.route) },
                        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary),
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier.width(150.dp)
                    ) {
                        Icon(ImageVector.vectorResource(R.drawable.filter_solid), "filter icon",
                            modifier= Modifier.size(12.dp),
                            tint = MaterialTheme.colorScheme.onPrimary
                            )
                        Spacer(modifier = Modifier
                            .width(16.dp))
                        Text(
                            text= "Personality",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    }

                    Button(
                        onClick = { /**/ },
                        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.surface),
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier.width(150.dp)
                    ) {
                        Icon(ImageVector.vectorResource(R.drawable.filter_solid), "filter icon",
                            modifier= Modifier.size(12.dp),
                            tint = MaterialTheme.colorScheme.onSurface
                            )
                        Spacer(modifier = Modifier
                            .width(16.dp))
                        Text(
                            text= "Results",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }



                }


            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(15.dp))

            Box(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp))
                LazyColumn(
                    content = {
                        CoursesData.results.map { item { StarredCourseCard(it) } }
                    },
                    contentPadding = PaddingValues(
                        bottom = 100.dp
                    ),
                )

            }

        }
    }

}
data class Holland(val code: String, val details: String)
data class  HollandCourse(val hollandCode: Holland, val match: Int, val label: String, val courses: List<Course>)
@Composable
fun SuggestedCoursesPersonality(navController: NavHostController){
    Box(modifier = Modifier
        .background(MaterialTheme.colorScheme.background)
        .fillMaxSize()
    ){
        Column{

            Heading("Suggested Courses")
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(15.dp))


            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {

                Button(
                    onClick = { /**/ },
                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.surface),
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier.width(150.dp)
                ) {
                    Icon(ImageVector.vectorResource(R.drawable.filter_solid), "filter icon",
                        modifier= Modifier.size(12.dp),
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier
                        .width(16.dp))
                    Text(
                        text= "Personality",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }

                Button(
                    onClick = { navController.navigate(route = Screen.GradesCourses.route) },
                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary),
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier.width(150.dp)
                ) {
                    Icon(imageVector = ImageVector.vectorResource(R.drawable.filter_solid), "filter icon",
                        modifier= Modifier.size(12.dp),
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                    Spacer(modifier = Modifier
                        .width(16.dp))
                    Text(
                        text= "Results",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }



            }


            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(15.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp))
                LazyColumn(
                    content = {
                        CoursesData.personality.map { item { PersonalityFilteredCourses(it) } }
                    },
                    contentPadding = PaddingValues(
                        bottom = 100.dp
                    ),
                    horizontalAlignment = Alignment.CenterHorizontally
                )

            }

        }
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SuggestedCourses(courses: List<Course>){
    Spacer(modifier = Modifier
        .fillMaxWidth()
        .height(10.dp))
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Cyan),
        content = {
            courses.map { item { StarredCourseCard(it) } }
        },
    )
}

@Preview(showBackground = true)
@Preview(name="Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true)
@Composable
fun showSuggestedCoursesPreview(){
    WiseChoiceTheme {
        androidx.compose.material3.Surface {
            SuggestedCoursesPersonality(rememberNavController())
        }
    }
}






