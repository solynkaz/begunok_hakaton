package com.example.begunok_hakaton

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.begunok_hakaton.Screens.MainMenu.mainMenu
import com.example.begunok_hakaton.Screens.StudentRecord
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val systemUiController = rememberSystemUiController()
            systemUiController.setSystemBarsColor(
                color = Color.Transparent
            )
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "MainMenu") {
                composable("MainMenu") {
                    mainMenu(onNavToStudent = {
                        navController.navigate("studentRecords")
                    }, onNavToTeacher = {
                        navController.navigate("teacherRecords")
                    })
                }
                composable("studentRecords") {
                    StudentRecord(lessonName = "Программирование", yearOfStudy = "2022")
                }
                composable("teacherRecords") {

                }
            }
                //#region picture
                Row(
                    Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painterResource(id = R.drawable.group_174asd),
                        contentDescription = "",
                        alignment = Alignment.Center,
                        alpha = 0.4f
                    )
                }
                //endregion


                //val json = "{\"id\":\"1\",\"fio\":\"MaerkoLika\",\"lessons\":[{\"id\":\"1\",\"name\":\"Программирование\",\"date\":\"2022-10-10\",\"theme\":\"Множества\",\"teacher\":\"ЖамбаловЭ.Б.\",\"presence\":\"true\",\"type\":\"1\",\"maxBall\":\"14\",\"currentBall\":\"0\"}],\"active_arrears\":[{\"arrearDate\":\"2022-01-01\",\"arrearGrade\":\"5\"}]}"
                //val student: Student = Gson().fromJson(json, Student::class.java)
                //Log.d("StudentInfo", student.toString())
                //StudentRecord("Основы программной инженерии", "Программирование", "2022")
            }
        }
    }




