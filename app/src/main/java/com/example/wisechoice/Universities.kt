package com.example.wisechoice

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wisechoice.sampledata.CoursesData
import com.example.wisechoice.ui.theme.WiseChoiceTheme

data class Cutoff(val year: Int, val cutoff: Float)
data class University(val id: Int, val name: String, val logo: String, val cutoff: Array<Cutoff>)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Universities(courseId: Int?){

    Column {
        Heading(title = "course id = " + courseId.toString())
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
        )

        Box(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
            )

            val universities = CoursesData.filtered
            LazyColumn {
                universities.map { item { UniversityCard(it) } }
            }


        }
    }
}

@Preview(showBackground = true)
@Preview(name="Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true)
@Composable
fun showUniversitiesScreen(){
    WiseChoiceTheme {
        Universities(1)
    }
}