package com.example.wisechoice

import android.icu.lang.UCharacter.LineBreak
import android.view.RoundedCorner
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.material3.Button
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.wisechoice.sampledata.UsersData
import com.example.wisechoice.ui.theme.*
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun Grades(userId: Int?, navController: NavHostController) {
    val user = UsersData.user1
    Box(
        modifier = Modifier
            .background(androidx.compose.material3.MaterialTheme.colorScheme.tertiary)
            .fillMaxSize()
    )
    {
        Column(
        ) {
            //the nav part
            Row(
                modifier = Modifier
                    .height(80.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Spacer(modifier = Modifier.width(20.dp))
                IconButton(
                    onClick = { navController.navigate(route = BottomBarScreen.Profile.route) },
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(androidx.compose.material3.MaterialTheme.colorScheme.onPrimary)
                        .width(40.dp)
                        .height(40.dp)
                        .border(2.dp, Color(0xFFF6F2F6), CircleShape)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "",
                        tint = Color(0xFF301934)
                    )
                }
                Spacer(modifier = Modifier.width(50.dp))
                Text(
                    text = "KCSE results",
                    modifier = Modifier
                        .padding(20.dp),
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onTertiary,

                    )
            }

            //The box part
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
                        text = "Fill in your KCSE results",
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center,
                        color = purple_900,

                        )
                }

            }
            Spacer(modifier = Modifier.height(20.dp))
            //The content part
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.background),

                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column {
                    Card(
                        modifier = Modifier
                            .padding(all = 30.dp)
                            .width(330.dp)
                            .height(120.dp)
                            .shadow(10.dp),
                        backgroundColor = MaterialTheme.colorScheme.surface
                    ) {
                        Column( modifier = Modifier
                            .padding(start=15.dp, end=10.dp, top=20.dp, bottom=10.dp)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {

                                Text(
                                    text = "Your Grades:",
                                    style = MaterialTheme.typography.bodyLarge,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurface
                                )

                            }
                            Spacer(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(6.dp)
                            )
                            Text(
                                text = "Maths: ${user.grades.math} | English: ${user.grades.eng} |" +
                                        "Kiswahili: ${user.grades.swa} | Physics: ${user.grades.phy} |" +
                                        " Chemistry: ${user.grades.chem} | History: ${user.grades.hist} | Geography: ${user.grades.geo} ",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )

                            Row(
                                modifier = Modifier
                                    .height(30.dp)
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.End
                            )
                            {
                                IconButton(
                                    onClick = { /*TODO*/ },
                                    modifier = Modifier
                                        .clip(CircleShape)
                                        .background(purple_100)
                                        .width(30.dp)
                                        .height(30.dp)
                                        .border(2.dp, Color(0xFFF6F2F6), CircleShape)

                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Edit,
                                        contentDescription = "",
                                        tint = Color(0xFFFFFFFF),
                                        modifier = Modifier
                                            .height(15.dp)
                                            .width(20.dp)
                                    )
                                }
                            }
                        }


                    }
                }
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp)
                )
                Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth())
                {
                    Divider(
                        color = grey_50, thickness = 1.6.dp, modifier = Modifier
                            .fillMaxWidth(0.9f)
                    )
                }
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp)
                )
                Column() {

                    Column(modifier=Modifier.fillMaxWidth(0.8f))
                    {

                        val subjects = listOf("Mathematics", "English", "Kiswahili", "Physics", "Chemistry", "History", "Geography")
                        dropDown(subjects, "Select Subject")

                        Spacer(modifier = Modifier.height(10.dp))

                        Spacer(modifier = Modifier.height(5.dp))


                        val scores = listOf("A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "E")
                        dropDown(scores, "Select Grade")

                    }
                }
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                )
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {


                    Column()
                    {
                        Button(
                            onClick = {
                                navController.navigate(route = Screen.Grades.passId(user.id))
                                      },
                            colors = androidx.compose.material3.ButtonDefaults.buttonColors(androidx.compose.material3.MaterialTheme.colorScheme.tertiary),
                            modifier = Modifier.width(200.dp)
                        ) {
                            Text(
                                text = "ADD",
                                modifier = Modifier,
                                color = MaterialTheme.colorScheme.onTertiary,
                                style = MaterialTheme.typography.bodyLarge,
                                textAlign = TextAlign.Center

                            )
                        }

                    }
                }

            }

        }

    }
}


@Composable
fun dropDown(list:  List<String>, lbl: String){
    var expanded by remember { mutableStateOf(false)}
    val list = list
    var selectedItem by remember {mutableStateOf("")}
    var textFieldSize by remember {mutableStateOf(Size.Zero)}
    val icon = if (expanded){
        Icons.Filled.KeyboardArrowUp
    }else{
        Icons.Filled.KeyboardArrowDown
    }

    Column(modifier = Modifier.padding(0.dp)){
        OutlinedTextField(
            value = selectedItem,
            onValueChange = {selectedItem = it},
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates -> textFieldSize = coordinates.size.toSize() },
            label = {Text(lbl)},
            trailingIcon = {
                Icon(icon, "", Modifier.clickable{expanded = !expanded})
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = MaterialTheme.colorScheme.onBackground,
                textColor = MaterialTheme.colorScheme.onBackground),

        )
        
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false},
            modifier = Modifier
                .width(with(LocalDensity.current){textFieldSize.width.toDp()})
                .background(MaterialTheme.colorScheme.surface),

            ) {
            list.forEach{label->
                DropdownMenuItem(onClick = {
                    selectedItem = label
                    expanded = false
                }) {
                    Text(text=label,  color = MaterialTheme.colorScheme.onSurface,)
                }
            }

        }
    }
}


@Preview
@Composable
fun PreviewGradeScreen() {
    Grades(1, rememberNavController())
}
