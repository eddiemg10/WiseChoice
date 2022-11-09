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
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.*
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.ImagePainter.State.Empty.painter
import com.example.wisechoice.sampledata.CoursesData
import com.example.wisechoice.ui.theme.WiseChoiceTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment




data class SuggestedCourses(val name: String, val university: String, val star: String, val pic: String)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SuggestedCourses(){
    Box(modifier = Modifier
        .background(MaterialTheme.colorScheme.background)
        .fillMaxSize()
    ){
        Column{

            Heading("Suggested Courses")
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(15.dp))

            Surface(
                modifier = Modifier
                    .fillMaxWidth(),
                color = MaterialTheme.colorScheme.onPrimary,
                shadowElevation = 8.dp,
            ) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    ButtonwithIcon("Personality", {/*TODO*/})
                    ButtonwithIcon("Filter", {/*TODO*/})
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
                        CoursesData.explore.map { item { StarredCourseCard(it) } }
                    },
                )

            }

        }


        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(MaterialTheme.colorScheme.secondary)
                .align(Alignment.BottomCenter)
        )

        {
            Text("NavBar")
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
            SuggestedCourses()
        }
    }
}






