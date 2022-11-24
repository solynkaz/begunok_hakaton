package com.example.begunok_hakaton

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.begunok_hakaton.dataclasses.GroupDataClasses.Group
import com.example.begunok_hakaton.dataclasses.StudentDataClasses.Student
import com.example.begunok_hakaton.screens.StudentRecord
import com.example.begunok_hakaton.screens.TeacherRecord
import com.example.begunok_hakaton.screens.mainMenu.mainMenu

import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.google.gson.Gson

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val json =
                "{\r\n\t\"id\": \"1\",\r\n\t\"students\": [{\r\n\t\t\t\"id\": \"1\",\r\n\t\t\t\"fio\": \"Главинская Арина Александровна\",\r\n\t\t\t\"lessons\": [{\r\n\t\t\t\t\t\"id\": \"1\",\r\n\t\t\t\t\t\"name\": \"Программирование\",\r\n\t\t\t\t\t\"date\": \"2022-10-09\",\r\n\t\t\t\t\t\"theme\": \"Введение в программирование\",\r\n\t\t\t\t\t\"teacher\": \"Жамбалов Э.Б.\",\r\n\t\t\t\t\t\"presence\": \"true\",\r\n\t\t\t\t\t\"type\": \"1\",\r\n\t\t\t\t\t\"maxBall\": \"16\",\r\n\t\t\t\t\t\"currentBall\": \"14\"\r\n\t\t\t\t},\r\n\t\t\t\t{\r\n\t\t\t\t\t\"id\": \"2\",\r\n\t\t\t\t\t\"name\": \"Программирование\",\r\n\t\t\t\t\t\"date\": \"2022-10-10\",\r\n\t\t\t\t\t\"theme\": \"Основы алгоритмизации\",\r\n\t\t\t\t\t\"teacher\": \"Жамбалов Э.Б.\",\r\n\t\t\t\t\t\"presence\": \"true\",\r\n\t\t\t\t\t\"type\": \"1\",\r\n\t\t\t\t\t\"maxBall\": \"16\",\r\n\t\t\t\t\t\"currentBall\": \"15\"\r\n\t\t\t\t},\r\n\t\t\t\t{\r\n\t\t\t\t\t\"id\": \"3\",\r\n\t\t\t\t\t\"name\": \"Программирование\",\r\n\t\t\t\t\t\"date\": \"2022-20-11\",\r\n\t\t\t\t\t\"theme\": \"Простейшие конструкции языка С\",\r\n\t\t\t\t\t\"teacher\": \"Жамбалов Э.Б.\",\r\n\t\t\t\t\t\"presence\": \"true\",\r\n\t\t\t\t\t\"type\": \"1\",\r\n\t\t\t\t\t\"maxBall\": \"16\",\r\n\t\t\t\t\t\"currentBall\": \"16\"\r\n\t\t\t\t},\r\n\t\t\t\t{\r\n\t\t\t\t\t\"id\": \"4\",\r\n\t\t\t\t\t\"name\": \"Программирование\",\r\n\t\t\t\t\t\"date\": \"2022-20-12\",\r\n\t\t\t\t\t\"theme\": \"Экзамен\",\r\n\t\t\t\t\t\"teacher\": \"Жамбалов Э.Б.\",\r\n\t\t\t\t\t\"presence\": \"true\",\r\n\t\t\t\t\t\"type\": \"2\",\r\n\t\t\t\t\t\"maxBall\": \"24\",\r\n\t\t\t\t\t\"currentBall\": \"18\"\r\n\t\t\t\t}\r\n\t\t\t]\r\n\t\t},\r\n\r\n\t\t{\r\n\t\t\t\"id\": \"2\",\r\n\t\t\t\"fio\": \"Дугаров Вячеслав Александрович\",\r\n\t\t\t\"lessons\": [{\r\n\t\t\t\t\t\"id\": \"1\",\r\n\t\t\t\t\t\"name\": \"Программирование\",\r\n\t\t\t\t\t\"date\": \"2022-10-09\",\r\n\t\t\t\t\t\"theme\": \"Введение в программирование\",\r\n\t\t\t\t\t\"teacher\": \"Жамбалов Э.Б.\",\r\n\t\t\t\t\t\"presence\": \"true\",\r\n\t\t\t\t\t\"type\": \"1\",\r\n\t\t\t\t\t\"maxBall\": \"16\",\r\n\t\t\t\t\t\"currentBall\": \"0\"\r\n\t\t\t\t},\r\n\t\t\t\t{\r\n\t\t\t\t\t\"id\": \"2\",\r\n\t\t\t\t\t\"name\": \"Программирование\",\r\n\t\t\t\t\t\"date\": \"2022-10-10\",\r\n\t\t\t\t\t\"theme\": \"Основы алгоритмизации\",\r\n\t\t\t\t\t\"teacher\": \"Жамбалов Э.Б.\",\r\n\t\t\t\t\t\"presence\": \"true\",\r\n\t\t\t\t\t\"type\": \"1\",\r\n\t\t\t\t\t\"maxBall\": \"16\",\r\n\t\t\t\t\t\"currentBall\": \"0\"\r\n\t\t\t\t},\r\n\t\t\t\t{\r\n\t\t\t\t\t\"id\": \"3\",\r\n\t\t\t\t\t\"name\": \"Программирование\",\r\n\t\t\t\t\t\"date\": \"2022-20-11\",\r\n\t\t\t\t\t\"theme\": \"Простейшие конструкции языка С\",\r\n\t\t\t\t\t\"teacher\": \"Жамбалов Э.Б.\",\r\n\t\t\t\t\t\"presence\": \"true\",\r\n\t\t\t\t\t\"type\": \"1\",\r\n\t\t\t\t\t\"maxBall\": \"16\",\r\n\t\t\t\t\t\"currentBall\": \"0\"\r\n\t\t\t\t},\r\n\t\t\t\t{\r\n\t\t\t\t\t\"id\": \"4\",\r\n\t\t\t\t\t\"name\": \"Программирование\",\r\n\t\t\t\t\t\"date\": \"2022-20-12\",\r\n\t\t\t\t\t\"theme\": \"Экзамен\",\r\n\t\t\t\t\t\"teacher\": \"Жамбалов Э.Б.\",\r\n\t\t\t\t\t\"presence\": \"true\",\r\n\t\t\t\t\t\"type\": \"2\",\r\n\t\t\t\t\t\"maxBall\": \"24\",\r\n\t\t\t\t\t\"currentBall\": \"0\"\r\n\t\t\t\t}\r\n\t\t\t],\r\n\t\t\t\"active_arrears\": [{\r\n\t\t\t\t\"idLesson\": \"4\",\r\n\t\t\t\t\"arrearDate\": \"2022-01-01\",\r\n\t\t\t\t\"arrearGrade\": \"5\"\r\n\t\t\t}]\r\n\t\t},\r\n\r\n\t\t{\r\n\t\t\t\"id\": \"3\",\r\n\t\t\t\"fio\": \"Зайцев Максим Алексеевич\",\r\n\t\t\t\"lessons\": [{\r\n\t\t\t\t\t\"id\": \"1\",\r\n\t\t\t\t\t\"name\": \"Программирование\",\r\n\t\t\t\t\t\"date\": \"2022-10-09\",\r\n\t\t\t\t\t\"theme\": \"Введение в программирование\",\r\n\t\t\t\t\t\"teacher\": \"Жамбалов Э.Б.\",\r\n\t\t\t\t\t\"presence\": \"true\",\r\n\t\t\t\t\t\"type\": \"1\",\r\n\t\t\t\t\t\"maxBall\": \"16\",\r\n\t\t\t\t\t\"currentBall\": \"16\"\r\n\t\t\t\t},\r\n\t\t\t\t{\r\n\t\t\t\t\t\"id\": \"2\",\r\n\t\t\t\t\t\"name\": \"Программирование\",\r\n\t\t\t\t\t\"date\": \"2022-10-10\",\r\n\t\t\t\t\t\"theme\": \"Основы алгоритмизации\",\r\n\t\t\t\t\t\"teacher\": \"Жамбалов Э.Б.\",\r\n\t\t\t\t\t\"presence\": \"true\",\r\n\t\t\t\t\t\"type\": \"1\",\r\n\t\t\t\t\t\"maxBall\": \"16\",\r\n\t\t\t\t\t\"currentBall\": \"16\"\r\n\t\t\t\t},\r\n\t\t\t\t{\r\n\t\t\t\t\t\"id\": \"3\",\r\n\t\t\t\t\t\"name\": \"Программирование\",\r\n\t\t\t\t\t\"date\": \"2022-20-11\",\r\n\t\t\t\t\t\"theme\": \"Простейшие конструкции языка С\",\r\n\t\t\t\t\t\"teacher\": \"Жамбалов Э.Б.\",\r\n\t\t\t\t\t\"presence\": \"true\",\r\n\t\t\t\t\t\"type\": \"1\",\r\n\t\t\t\t\t\"maxBall\": \"16\",\r\n\t\t\t\t\t\"currentBall\": \"16\"\r\n\t\t\t\t},\r\n\t\t\t\t{\r\n\t\t\t\t\t\"id\": \"4\",\r\n\t\t\t\t\t\"name\": \"Программирование\",\r\n\t\t\t\t\t\"date\": \"2022-20-12\",\r\n\t\t\t\t\t\"theme\": \"Экзамен\",\r\n\t\t\t\t\t\"teacher\": \"Жамбалов Э.Б.\",\r\n\t\t\t\t\t\"presence\": \"true\",\r\n\t\t\t\t\t\"type\": \"2\",\r\n\t\t\t\t\t\"maxBall\": \"24\",\r\n\t\t\t\t\t\"currentBall\": \"20\"\r\n\t\t\t\t}\r\n\t\t\t]\r\n\t\t},\r\n\r\n\t\t{\r\n\t\t\t\"id\": \"4\",\r\n\t\t\t\"fio\": \"Казарян Ярослав Араратович\",\r\n\t\t\t\"lessons\": [{\r\n\t\t\t\t\t\"id\": \"1\",\r\n\t\t\t\t\t\"name\": \"Программирование\",\r\n\t\t\t\t\t\"date\": \"2022-10-09\",\r\n\t\t\t\t\t\"theme\": \"Введение в программирование\",\r\n\t\t\t\t\t\"teacher\": \"Жамбалов Э.Б.\",\r\n\t\t\t\t\t\"presence\": \"true\",\r\n\t\t\t\t\t\"type\": \"1\",\r\n\t\t\t\t\t\"maxBall\": \"16\",\r\n\t\t\t\t\t\"currentBall\": \"0\"\r\n\t\t\t\t},\r\n\t\t\t\t{\r\n\t\t\t\t\t\"id\": \"2\",\r\n\t\t\t\t\t\"name\": \"Программирование\",\r\n\t\t\t\t\t\"date\": \"2022-10-10\",\r\n\t\t\t\t\t\"theme\": \"Основы алгоритмизации\",\r\n\t\t\t\t\t\"teacher\": \"Жамбалов Э.Б.\",\r\n\t\t\t\t\t\"presence\": \"true\",\r\n\t\t\t\t\t\"type\": \"1\",\r\n\t\t\t\t\t\"maxBall\": \"16\",\r\n\t\t\t\t\t\"currentBall\": \"0\"\r\n\t\t\t\t},\r\n\t\t\t\t{\r\n\t\t\t\t\t\"id\": \"3\",\r\n\t\t\t\t\t\"name\": \"Программирование\",\r\n\t\t\t\t\t\"date\": \"2022-20-11\",\r\n\t\t\t\t\t\"theme\": \"Простейшие конструкции языка С\",\r\n\t\t\t\t\t\"teacher\": \"Жамбалов Э.Б.\",\r\n\t\t\t\t\t\"presence\": \"true\",\r\n\t\t\t\t\t\"type\": \"1\",\r\n\t\t\t\t\t\"maxBall\": \"16\",\r\n\t\t\t\t\t\"currentBall\": \"0\"\r\n\t\t\t\t},\r\n\t\t\t\t{\r\n\t\t\t\t\t\"id\": \"4\",\r\n\t\t\t\t\t\"name\": \"Программирование\",\r\n\t\t\t\t\t\"date\": \"2022-20-12\",\r\n\t\t\t\t\t\"theme\": \"Экзамен\",\r\n\t\t\t\t\t\"teacher\": \"Жамбалов Э.Б.\",\r\n\t\t\t\t\t\"presence\": \"true\",\r\n\t\t\t\t\t\"type\": \"2\",\r\n\t\t\t\t\t\"maxBall\": \"24\",\r\n\t\t\t\t\t\"currentBall\": \"0\"\r\n\t\t\t\t}\r\n\t\t\t]\r\n\t\t}\r\n\t],\r\n\t\"groupName\": \"Б760\"\r\n}"
            val group: Group = Gson().fromJson(json, Group::class.java)
            val students: ArrayList<Student> = group.students

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
                    TeacherRecord(group)
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

        }
    }
}




