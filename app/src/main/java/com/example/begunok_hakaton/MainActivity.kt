package com.example.begunok_hakaton

import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.begunok_hakaton.dataclasses.GroupDataClasses.Group
import com.example.begunok_hakaton.dataclasses.StudentDataClasses.Student
import com.example.begunok_hakaton.screens.StudentRecord
import com.example.begunok_hakaton.screens.TeacherRecord
import com.example.begunok_hakaton.screens.mainMenu.mainMenu
import com.example.begunok_hakaton.screens.testScreen
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.google.gson.Gson

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var studentForTeacherJournal: Student? = null
        val json =
            "{\r\n\t\"id\": \"1\",\r\n\t\"students\": [{\r\n\t\t\t\"id\": \"1\",\r\n\t\t\t\"fio\": \"Главинская Арина Александровна\",\r\n\t\t\t\"lessons\": [{\r\n\t\t\t\t\t\"id\": \"1\",\r\n\t\t\t\t\t\"name\": \"Программирование\",\r\n\t\t\t\t\t\"date\": \"12.12.2021\",\r\n\t\t\t\t\t\"theme\": \"Введение в программирование\",\r\n\t\t\t\t\t\"teacher\": \"Жамбалов Э.Б.\",\r\n\t\t\t\t\t\"presence\": \"true\",\r\n\t\t\t\t\t\"type\": \"1\",\r\n\t\t\t\t\t\"maxBall\": \"16\",\r\n\t\t\t\t\t\"currentBall\": \"14\"\r\n\t\t\t\t},\r\n\t\t\t\t{\r\n\t\t\t\t\t\"id\": \"2\",\r\n\t\t\t\t\t\"name\": \"Программирование\",\r\n\t\t\t\t\t\"date\": \"09.10.2021\",\r\n\t\t\t\t\t\"theme\": \"Основы алгоритмизации\",\r\n\t\t\t\t\t\"teacher\": \"Жамбалов Э.Б.\",\r\n\t\t\t\t\t\"presence\": \"true\",\r\n\t\t\t\t\t\"type\": \"1\",\r\n\t\t\t\t\t\"maxBall\": \"16\",\r\n\t\t\t\t\t\"currentBall\": \"15\"\r\n\t\t\t\t},\r\n\t\t\t\t{\r\n\t\t\t\t\t\"id\": \"3\",\r\n\t\t\t\t\t\"name\": \"Программирование\",\r\n\t\t\t\t\t\"date\": \"2022-20-11\",\r\n\t\t\t\t\t\"theme\": \"Простейшие конструкции языка С\",\r\n\t\t\t\t\t\"teacher\": \"Жамбалов Э.Б.\",\r\n\t\t\t\t\t\"presence\": \"true\",\r\n\t\t\t\t\t\"type\": \"1\",\r\n\t\t\t\t\t\"maxBall\": \"16\",\r\n\t\t\t\t\t\"currentBall\": \"16\"\r\n\t\t\t\t},\r\n\t\t\t\t{\r\n\t\t\t\t\t\"id\": \"4\",\r\n\t\t\t\t\t\"name\": \"Программирование\",\r\n\t\t\t\t\t\"date\": \"24.12.2021\",\r\n\t\t\t\t\t\"theme\": \"Экзамен\",\r\n\t\t\t\t\t\"teacher\": \"Жамбалов Э.Б.\",\r\n\t\t\t\t\t\"presence\": \"true\",\r\n\t\t\t\t\t\"type\": \"2\",\r\n\t\t\t\t\t\"maxBall\": \"24\",\r\n\t\t\t\t\t\"currentBall\": \"56\"\r\n\t\t\t\t}\r\n\t\t\t]\r\n\t\t},\r\n\r\n\t\t{\r\n\t\t\t\"id\": \"2\",\r\n\t\t\t\"fio\": \"Дугаров Вячеслав Александрович\",\r\n\t\t\t\"lessons\": [{\r\n\t\t\t\t\t\"id\": \"1\",\r\n\t\t\t\t\t\"name\": \"Программирование\",\r\n\t\t\t\t\t\"date\": \"05.10.2021\",\r\n\t\t\t\t\t\"theme\": \"Введение в программирование\",\r\n\t\t\t\t\t\"teacher\": \"Жамбалов Э.Б.\",\r\n\t\t\t\t\t\"presence\": \"true\",\r\n\t\t\t\t\t\"type\": \"1\",\r\n\t\t\t\t\t\"maxBall\": \"16\",\r\n\t\t\t\t\t\"currentBall\": \"0\"\r\n\t\t\t\t},\r\n\t\t\t\t{\r\n\t\t\t\t\t\"id\": \"2\",\r\n\t\t\t\t\t\"name\": \"Программирование\",\r\n\t\t\t\t\t\"date\": \"09.10.2021\",\r\n\t\t\t\t\t\"theme\": \"Основы алгоритмизации\",\r\n\t\t\t\t\t\"teacher\": \"Жамбалов Э.Б.\",\r\n\t\t\t\t\t\"presence\": \"true\",\r\n\t\t\t\t\t\"type\": \"1\",\r\n\t\t\t\t\t\"maxBall\": \"16\",\r\n\t\t\t\t\t\"currentBall\": \"0\"\r\n\t\t\t\t},\r\n\t\t\t\t{\r\n\t\t\t\t\t\"id\": \"3\",\r\n\t\t\t\t\t\"name\": \"Программирование\",\r\n\t\t\t\t\t\"date\": \"12.12.2021\",\r\n\t\t\t\t\t\"theme\": \"Простейшие конструкции языка С\",\r\n\t\t\t\t\t\"teacher\": \"Жамбалов Э.Б.\",\r\n\t\t\t\t\t\"presence\": \"true\",\r\n\t\t\t\t\t\"type\": \"1\",\r\n\t\t\t\t\t\"maxBall\": \"16\",\r\n\t\t\t\t\t\"currentBall\": \"0\"\r\n\t\t\t\t},\r\n\t\t\t\t{\r\n\t\t\t\t\t\"id\": \"4\",\r\n\t\t\t\t\t\"name\": \"Программирование\",\r\n\t\t\t\t\t\"date\": \"24.12.2021\",\r\n\t\t\t\t\t\"theme\": \"Экзамен\",\r\n\t\t\t\t\t\"teacher\": \"Жамбалов Э.Б.\",\r\n\t\t\t\t\t\"presence\": \"true\",\r\n\t\t\t\t\t\"type\": \"2\",\r\n\t\t\t\t\t\"maxBall\": \"24\",\r\n\t\t\t\t\t\"currentBall\": \"0\"\r\n\t\t\t\t}\r\n\t\t\t],\r\n\t\t\t\"active_arrears\": [{\r\n\t\t\t\t\"idLesson\": \"4\",\r\n\t\t\t\t\"arrearDate\": \"2022-01-01\",\r\n\t\t\t\t\"arrearGrade\": \"5\"\r\n\t\t\t}]\r\n\t\t},\r\n\r\n\t\t{\r\n\t\t\t\"id\": \"3\",\r\n\t\t\t\"fio\": \"Зайцев Максим Алексеевич\",\r\n\t\t\t\"lessons\": [{\r\n\t\t\t\t\t\"id\": \"1\",\r\n\t\t\t\t\t\"name\": \"Программирование\",\r\n\t\t\t\t\t\"date\": \"12.12-2021\",\r\n\t\t\t\t\t\"theme\": \"Введение в программирование\",\r\n\t\t\t\t\t\"teacher\": \"Жамбалов Э.Б.\",\r\n\t\t\t\t\t\"presence\": \"true\",\r\n\t\t\t\t\t\"type\": \"1\",\r\n\t\t\t\t\t\"maxBall\": \"16\",\r\n\t\t\t\t\t\"currentBall\": \"16\"\r\n\t\t\t\t},\r\n\t\t\t\t{\r\n\t\t\t\t\t\"id\": \"2\",\r\n\t\t\t\t\t\"name\": \"Программирование\",\r\n\t\t\t\t\t\"date\": \"12.12.2021\",\r\n\t\t\t\t\t\"theme\": \"Основы алгоритмизации\",\r\n\t\t\t\t\t\"teacher\": \"Жамбалов Э.Б.\",\r\n\t\t\t\t\t\"presence\": \"true\",\r\n\t\t\t\t\t\"type\": \"1\",\r\n\t\t\t\t\t\"maxBall\": \"16\",\r\n\t\t\t\t\t\"currentBall\": \"16\"\r\n\t\t\t\t},\r\n\t\t\t\t{\r\n\t\t\t\t\t\"id\": \"3\",\r\n\t\t\t\t\t\"name\": \"Программирование\",\r\n\t\t\t\t\t\"date\": \"2022-20-11\",\r\n\t\t\t\t\t\"theme\": \"Простейшие конструкции языка С\",\r\n\t\t\t\t\t\"teacher\": \"Жамбалов Э.Б.\",\r\n\t\t\t\t\t\"presence\": \"true\",\r\n\t\t\t\t\t\"type\": \"1\",\r\n\t\t\t\t\t\"maxBall\": \"16\",\r\n\t\t\t\t\t\"currentBall\": \"16\"\r\n\t\t\t\t},\r\n\t\t\t\t{\r\n\t\t\t\t\t\"id\": \"4\",\r\n\t\t\t\t\t\"name\": \"Программирование\",\r\n\t\t\t\t\t\"date\": \"24.12.2021\",\r\n\t\t\t\t\t\"theme\": \"Экзамен\",\r\n\t\t\t\t\t\"teacher\": \"Жамбалов Э.Б.\",\r\n\t\t\t\t\t\"presence\": \"true\",\r\n\t\t\t\t\t\"type\": \"2\",\r\n\t\t\t\t\t\"maxBall\": \"24\",\r\n\t\t\t\t\t\"currentBall\": \"64\"\r\n\t\t\t\t}\r\n\t\t\t]\r\n\t\t},\r\n\r\n\t\t{\r\n\t\t\t\"id\": \"4\",\r\n\t\t\t\"fio\": \"Казарян Ярослав Араратович\",\r\n\t\t\t\"lessons\": [{\r\n\t\t\t\t\t\"id\": \"1\",\r\n\t\t\t\t\t\"name\": \"Программирование\",\r\n\t\t\t\t\t\"date\": \"12.12-2021\",\r\n\t\t\t\t\t\"theme\": \"Введение в программирование\",\r\n\t\t\t\t\t\"teacher\": \"Жамбалов Э.Б.\",\r\n\t\t\t\t\t\"presence\": \"true\",\r\n\t\t\t\t\t\"type\": \"1\",\r\n\t\t\t\t\t\"maxBall\": \"16\",\r\n\t\t\t\t\t\"currentBall\": \"0\"\r\n\t\t\t\t},\r\n\t\t\t\t{\r\n\t\t\t\t\t\"id\": \"2\",\r\n\t\t\t\t\t\"name\": \"Программирование\",\r\n\t\t\t\t\t\"date\": \"09.10.2021\",\r\n\t\t\t\t\t\"theme\": \"Основы алгоритмизации\",\r\n\t\t\t\t\t\"teacher\": \"Жамбалов Э.Б.\",\r\n\t\t\t\t\t\"presence\": \"true\",\r\n\t\t\t\t\t\"type\": \"1\",\r\n\t\t\t\t\t\"maxBall\": \"16\",\r\n\t\t\t\t\t\"currentBall\": \"0\"\r\n\t\t\t\t},\r\n\t\t\t\t{\r\n\t\t\t\t\t\"id\": \"3\",\r\n\t\t\t\t\t\"name\": \"Программирование\",\r\n\t\t\t\t\t\"date\": \"2022-20-11\",\r\n\t\t\t\t\t\"theme\": \"Простейшие конструкции языка С\",\r\n\t\t\t\t\t\"teacher\": \"Жамбалов Э.Б.\",\r\n\t\t\t\t\t\"presence\": \"true\",\r\n\t\t\t\t\t\"type\": \"1\",\r\n\t\t\t\t\t\"maxBall\": \"16\",\r\n\t\t\t\t\t\"currentBall\": \"0\"\r\n\t\t\t\t},\r\n\t\t\t\t{\r\n\t\t\t\t\t\"id\": \"4\",\r\n\t\t\t\t\t\"name\": \"Программирование\",\r\n\t\t\t\t\t\"date\": \"24.12.2021\",\r\n\t\t\t\t\t\"theme\": \"Экзамен\",\r\n\t\t\t\t\t\"teacher\": \"Жамбалов Э.Б.\",\r\n\t\t\t\t\t\"presence\": \"true\",\r\n\t\t\t\t\t\"type\": \"2\",\r\n\t\t\t\t\t\"maxBall\": \"24\",\r\n\t\t\t\t\t\"currentBall\": \"70\"\r\n\t\t\t\t}\r\n\t\t\t]\r\n\t\t}\r\n\t],\r\n\t\"groupName\": \"Б760\"\r\n}"
        val pref: SharedPreferences =
            this.getSharedPreferences("prefs", MODE_PRIVATE)
        pref.edit().putString("data", json).apply()
        setContent {

            val fileName = "data.txt"
            val group: Group = Gson().fromJson(pref.getString("data", ""), Group::class.java)
            val students: ArrayList<Student> = group.students
            val systemUiController = rememberSystemUiController()
            systemUiController.setSystemBarsColor(
                color = Color.Transparent
            )
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "MainMenu") {

                composable("test") {
                    testScreen()
                    BackHandler(true) {
                    }
                }
                composable("MainMenu") {
                    mainMenu(
                        onNavToTeacher = {
                            navController.navigate("teacherRecords")
                        },
                        onNavToStudent = {
                            navController.navigate("studentRecords")
                        })
                    BackHandler(true) {
                    }
                }
                composable("teacherRecords") {
                    TeacherRecord(
                        group, onNavToCard = {
                            studentForTeacherJournal = it
                            navController.navigate("teacherJournalCard")
                        }, pref = pref, NavOnBack = {
                            navController.navigate("MainMenu")
                        })
                    BackHandler(true) {
                    }
                }
                composable("studentRecords") {
                    StudentRecord(students[1], pref, NavOnBack = {
                        navController.navigate("MainMenu")
                    })
                    BackHandler(true) {
                    }
                }
                composable("teacherJournalCard") {
                    RunnerScreen(studentForTeacherJournal!!, pref, NavOnBack = {
                        navController.navigate("teacherRecords")
                    })
                    BackHandler(true) {
                    }
                }
            }
            //#region picture
            //endregion

        }
    }
}




